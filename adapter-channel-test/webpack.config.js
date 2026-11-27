const HtmlWebpackPlugin = require('html-webpack-plugin');
const CopyPlugin = require("copy-webpack-plugin");
const { CleanWebpackPlugin } = require('clean-webpack-plugin');  
const path = require('path');

module.exports = (env, argv) => {

    const rootUrl = argv.mode === 'development' ? 
                        'http://localhost:5555' : 
                        'http://testing-assets.openfin.co.s3-website-us-east-1.amazonaws.com/adapters/channel';
                        // should use 'https://testing-assets.openfin.co/adapters/channel' , but old version of .Net does not like https

    return {
        entry: {
            provider: './src/provider.ts',
            client: './src/client.ts',
        },
        output: {
            path: path.resolve(__dirname, './out'),
            filename: '[name].[contenthash].js'
        },
        resolve: {
            extensions: ['.ts', '.tsx', '.js', '.jsx', '.json']
        },
        module: {
            rules: [
                {
                    test: /\.tsx?$/,
                    use: [
                        {
                            loader: 'ts-loader',
                            options: {
                                transpileOnly: true
                            }
                        }
                    ]
                },
                {
                    test: /\.css$/,
                    use: ['style-loader','css-loader']
                }
            ]
        },
        plugins: [
            new CleanWebpackPlugin(),
            new HtmlWebpackPlugin({ 
                title: 'Adapter Channel Test provider',
                template: 'public/provider.html',
                filename: 'provider.html',
                chunks: ['provider']
            }),
            new HtmlWebpackPlugin({ 
                title: 'Adapter Channel Test client',
                template: 'public/client.html',
                filename: 'client.html',
                chunks: ['client']
            }),
            new HtmlWebpackPlugin({ 
                title: 'Adapter Channel Test',
                template: 'public/index.html',
                filename: 'index.html',
                chunks: ['client', 'provider']
            }),
            new CopyPlugin(
                {
                    patterns: [
                        { from: 'public/favicon.ico' },
                        { from: 'public/provider.json',
                          transform: (content) => {
                              const json = content.toString();
                              return json.replace(/\${APP_ROOT_URL}/g, rootUrl);
                          }
                        },
                        { from: 'public/client.json',
                          transform: (content) => {
                              const json = content.toString();
                              return json.replace(/\${APP_ROOT_URL}/g, rootUrl);
                          }
                        },
                        { from: 'public/app.json',
                          transform: (content) => {
                              const json = content.toString();
                              return json.replace(/\${APP_ROOT_URL}/g, rootUrl);
                          }
                        },
                    ]
                }
            )
        ],
        devServer: {
            static: [
                {directory: path.join(__dirname, 'out')},
            ],
            port: 5555,
            hot: 'only'
        }
    
    }
};
