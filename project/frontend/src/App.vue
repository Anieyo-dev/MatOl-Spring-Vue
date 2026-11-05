<template>
	<div class="app">
		<Navbar/>
		<div id="view">
  		<RouterView class="actualView"/>
		</div>
	</div>
</template>

<script >
import { RouterLink, RouterView } from "vue-router";
import InputText from 'primevue/inputtext';
import EventBus from './common/EventBus';
import Navbar from './components/Navbar.vue'

export default {
  components: {
    InputText,
		Navbar,
  },
	methods: {
		logOut() {
			this.$store.dispatch('auth/logout');
			this.$router.push('/login');
		},
	},
	mounted() {
		EventBus.on("logout", () => {
			this.logOut();
		});
	},
	beforeDestroy() {
		EventBus.remove("logout");
	}
};

</script>


<style >
#app {
	height: auto;
}

html {
	background: #f5f4f4;
}
#view {
	display: grid;
	grid-template-columns: [first]1fr [second]auto [third]1fr;
}

.actualView {
	grid-column: second;
}

body {
    display: block;
		margin: 0;
}
</style>
