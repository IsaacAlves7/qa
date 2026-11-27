using Newtonsoft.Json;
using System;
using System.Windows;
using Openfin.Desktop.Messaging;
using Fin = Openfin.Desktop;
using Newtonsoft.Json.Linq;

namespace Stub
{
    /// <summary>
    /// Interaction logic for MainWindow.xaml
    /// </summary>
    public partial class MainWindow : Window
    {
        const string RuntimeVersion = "21.90.59.17";
        const string ChannelName = "ChannelExample";
        private Fin.Runtime _fin;
        private ChannelClient _channelClient;

        public MainWindow()
        {
            InitializeComponent();
            ConnectToRuntime();
        }

        private void Button_Click(object sender, RoutedEventArgs e)
        {
            ConnectToChannel();
        }

        private void ConnectToRuntime()
        {
            var runtimeOptions = new Fin.RuntimeOptions
            {
                UUID = "stub",
                Version = RuntimeVersion,
                LicenseKey = "dotnettest",
                EnableRemoteDevTools = true,
                RuntimeConnectTimeout = 20000,
//                Port = 9696,
//                RuntimeConnectOptions = Fin.RuntimeConnectOptions.DirectLaunch | Fin.RuntimeConnectOptions.UseExternal,
            };

            _fin = Fin.Runtime.GetRuntimeInstance(runtimeOptions);            
            _fin.Error += (sender, e) =>
            {
                Console.WriteLine("Error om stub", e);
            };

            _fin.Connect(() =>
            {
                Application.Current.Dispatcher.Invoke(new Action(() => { 
                    Connect.IsEnabled = true;
                    Console.WriteLine("Connected to Runtime");
                }));                        
            });
        }

        private void ConnectToChannel()
        {
            ChannelConnectOptions opts = new ChannelConnectOptions(ChannelName)
            {
                Wait = true,
                Payload = "Hello from donet"
            };
            _channelClient = _fin.InterApplicationBus.Channel.CreateClient(opts);
            _channelClient.Opened += ChannelClient_Opened;
            _channelClient.Closed += ChannelClient_Closed;
            _channelClient.ConnectAsync();
        }

        private void ChannelClient_Opened(object sender, EventArgs e)
        {
            Console.WriteLine("channel opened");
            var payload = new JObject() { { "requestedBy", "donet code" } };
            _channelClient.DispatchAsync<JObject>("getValue", payload).ContinueWith((data) =>
            {
                Console.WriteLine("getValue returns:");
                Console.WriteLine(data.Result.ToString());
            });
        }
        private void ChannelClient_Closed(object sender, EventArgs e)
        {
            Console.WriteLine("channel disconnected");
            _channelClient.ConnectAsync();
        }
    }
}
