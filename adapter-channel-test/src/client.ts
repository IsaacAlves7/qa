import '../public/frame-styles.css';
import '../public/light-theme.css';

const CHANNEL_NAME = 'adapter-channel-test-adapter';  // provider is in adapter side

window.addEventListener('DOMContentLoaded', async () => {
    // @ts-ignore wait for new API to release
	const client = await fin.InterApplicationBus.Channel.connect(CHANNEL_NAME, { protocols: ['rtc'] });
    console.log('connected', client);
	client.register('client-action', (payload, identity) => {
        console.log('Action dispatched by provider: ', JSON.stringify(identity));
        console.log('Payload sent in dispatch: ', JSON.stringify(payload));
        return {
            value: payload.value
        };
	});
	const value = await client.dispatch('getValue');
	console.log(value);

});