<template>
	<div>
		<div class="navbar">
			<div class="left-elements">
				<p>
					<i 
						class="pi pi-fw pi-android"
						style="font-size: 35px">
					</i>
				</p>
				<div class="nav">
					<p	@click="dashboardRoute">
						Dashboard
					</p>
					<p @click="toggleSocial">
						Social
					</p>
					<TieredMenu 
							ref="socialTMenu"
							:model="social"
							:popup="true"
							:exact="true"
					>
					<template #item={item}>
						<a class="tMenuItem" @click="customRoute(item.route)">
							{{item.label}}
						</a>
						</template>
					</TieredMenu>
					<p>
						Support
					</p>
					<p @click="toggleGame">
						Games
					</p>
				</div>
				<TieredMenu 
					id="Game_tmenu"
					ref="gameTMenu"
					:model="games"
					:popup="true"
					@click="customRoute(games.item.route)"
					>
					<template #item={item}>
						<a class="tMenuItem" @click="customRoute(item.route)">
							{{item.label}}
						</a>
					</template>
				</TieredMenu>
			</div>
			<div class="right-elements">
				<p>
					<i class="pi pi-fw pi-user-edit"
						 style="font-size: 35px"
						 @click="accountSettingsRoute"
					></i>
				</p>
			</div>
		</div>
  </div>
</template>

<script>
import Button from 'primevue/button';
import TieredMenu from 'primevue/tieredmenu';

export default {
  name: "Navbar",
  components: {
		Button,
		TieredMenu,
  },
  data() {
		return {
			social: [
				{
					label:'Forum',
					route:'/forum',
				},
				{
					label:'News',
					route:'/news',
				},
				{
					label:'Path Notes',
					route:'/path-notes',
				},
				{
					label:'Opinions',
					route:'/opinions',
				},
			],
			games: [
				{
					label: 'Parkour',
					route: '/parkour',
				},
				{
					label: 'Adventure',
					route: '/adventure'
				}
			]
    }	
	},
	methods: {
		accountSettingsRoute() {
			this.$router.push('/account_settings')
		},
		dashboardRoute() {
			this.$router.push('/')
		},
		customRoute(path) {
			this.$router.push(path)
		},
		toggleSocial(event) {
			this.$refs.socialTMenu.toggle(event);
			console.log("toogle Social");
		},
		toggleGame(event) {
			this.$refs.gameTMenu.toggle(event);
		}
	}
}
</script>

<style scoped>

.navbar {
	display: flex;
	flex-direction: row;
	background-color: #fffbf9;
	border: purple solid 1px;
	margin: 5px;
	border-radius: 15px;
}

.navbar p {
	padding-left: 15px;
  font-size: 10px;
	color: black;
	cursor: pointer;
}

.navbar .left-elements {
	display: flex;
	flex-direction: row;
	gap: 5px;
	margin-top: 5px;
	margin-bottom: 5px;
}

.navbar .right-elements {
	display: flex;
  margin-left: auto;
  margin-right: 15px;
  margin-top: 5px;
}
.nav {
	display: flex;
	flex: row;
	padding-right: 15px;
}

.navbar .left-elements .nav p {
	font-size: 18px;
	color: rgb(90, 27, 90);
	border: purple;
}

.gameItem {
	font-size: 16px;
}


.tMenuItem {
	color: rgb(90, 27, 90);
	display: block;
	text-align: left;
	border-bottom: 0.5px solid rgb(219, 219, 219);
	padding-top: 6px;
	padding-left: 2px;
	width: 100%;
	height: 30px;
}

.tMenuItem:hover {
	background: rgb(243, 243, 243);
	cursor: pointer;
}
</style>