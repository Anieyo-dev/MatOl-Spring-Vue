<template>
  <div class="container">
    <h1>Jumpik</h1>
    <Card id="about" class="card">
      <template #title>
        About
      </template>
      <template #content>
        <p>Jumpik is a first platform game made by <b>Mikołaj Tkaczyk</b>.</p>
         
        <p>This is a simple platform game, it consists of 6 levels,
        each level has something different to offer you, skill, new enemies.</p>
      </template>
    </Card>
    <img src="../images/jumpik.png">
    <Card id="characters" class="card">
      <template #title>
        Choose character
      </template>
      <template #content>
        <p>If you choose new game, you will be able to select your skin.</p>
        <p>In this moment, there are 5 different skins.</p>
      </template>
    </Card>
    <Galleria :value="images" :responsiveOptions="responsiveOptions" :numVisible="5" containerStyle="max-width: 650px">
      <template #item="slotProps">
          <img :src="slotProps.item.itemImageSrc" :alt="slotProps.item.alt" style="width: 100%" />
      </template>
      <template #thumbnail="slotProps">
          <p style="color: white">{{slotProps.item.alt}}</p>
      </template>
    </Galleria>
    <Card id="skills" class="card">
      <template #title>
        Your skills
      </template>
      <template #content>
        <p>Depending on your level, you have access to other skills.</p>
        <p>In this moment, there are 2:</p>
        <li> Fireball </li>
        <li> Dash, that can kill enemy</li>
      </template>
    </Card>
    <Card id="enemies" class="card">
      <template #title>
        Different enemies
      </template>
      <template #content>
        <p>Depending on your level, you can encouter different enemies.</p>
      </template>
    </Card>
    <Card id="difficulty" class="card">
      <template #title>
        Hard skill check
      </template>
      <template #content>
        <p>This game can be realy annoying, if you are not good in platform games!</p>
        <p>Examples:</p>
      </template>
    </Card>
    <Card id="download" class="card">
      <template #title>
        How to get it?
      </template>
      <template #content>
        <p>It is realy easy to download. Click <a :href="linkToDownload">here</a> to be redirected.</p>
        <p>Don't forget to leave us your feedback <a @click="feedbackRoute">here</a>.</p>
        <p>Check out second game: <a @click="adventureRoute">Adventure</a>.</p>
      </template>
    </Card>
  </div>
</template>

<script>
import Card from 'primevue/card';
import Button from 'primevue/button';
import Galleria from 'primevue/galleria'

export default {
  components: {
    Card,
    Button,
    Galleria,
  },
  data() {
    return {
      linkToDownload: "https://truski42.itch.io/jumpik",
      images: [
        {
          itemImageSrc: "src/images/jumpik1.png",
          alt: 'fireball'
        },
        {
          itemImageSrc: 'src/images/jumpik2.png',
          alt: 'dash'
        },
      ]
    }
  },
  methods: {
    adventureRoute() {
      this.$router.push("/adventure")
    },
    feedbackRoute() {
      this.$router.push("/feedback")
    }
  },
}
</script>

<style scoped>
.card img {
  width: 650px;
}

.container {
  display: flex;
  flex-direction: column;
  gap: 10px;
  padding: 10px;
  background: #ffffff;
  border-radius: 20px;
}

.card {
  width: 650px;
}

:deep(.p-card-title) {
  margin-left: 5px;
}

:deep(.p-card-content) {
  display: flex;
  flex-direction: column;
  gap: 7px;
}

:deep(.p-card-content p) {
  margin: 0;
}

:deep(.p-card-content a) {
  color: rgb(248, 28, 28);
}

:deep(.p-card-content a:hover) {
  cursor: pointer;
}
</style>