import '../public/frame-styles.css';
import '../public/light-theme.css';

const CHANNEL_NAME = 'adapter-channel-test-js';

window.addEventListener('DOMContentLoaded', async () => {

    // @ts-ignore wait for new API to release
    const provider = await fin.InterApplicationBus.Channel.create(CHANNEL_NAME, { protocols: ['rtc', 'classic'] });
    provider.onConnection((identity, payload) => {
        console.log('Client connection request identity: ', JSON.stringify(identity));
        console.log('Client connection request payload: ', JSON.stringify(payload));
    });
 
    let value = 0;
    provider.register('getValue', (payload, identity) => {
        console.log('Action dispatched by client: ', JSON.stringify(identity));
        console.log('Payload sent in dispatch: ', JSON.stringify(payload));
        return {
            value: value
        };
    });
    provider.register('increment', (payload, identity) => {
        console.log('Action dispatched by client: ', JSON.stringify(identity));
        console.log('Payload sent in dispatch: ', JSON.stringify(payload));
        value = value + payload.value;
        return {
            value: value
        };
    });

    provider.register('triggerClientAction', (payload, identity) => {
        console.log('Action dispatched by client: ', JSON.stringify(identity));
        console.log('Payload sent in dispatch: ', JSON.stringify(payload));
        provider.publish('hellToClient', 'Hello');
        return {};
    });

 
});
