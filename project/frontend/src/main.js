import { createApp } from "vue";
import App from "./App.vue";
import router from "./router";
import store from './store';
import Primevue from "primevue/config";
import setupInteceptors from './services/setupInteceptors';
import "primeicons/primeicons.css";
import "primevue/resources/themes/saga-blue/theme.css";
import "primevue/resources/primevue.min.css";

setupInteceptors(store);

const app = createApp(App);

app.use(router);
app.use(Primevue);
app.use(store);
app.mount("#app");
