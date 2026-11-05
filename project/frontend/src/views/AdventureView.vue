<template>
  <div class="container">
    <Card>
      <template #title>
        <h1>Adventure (name in progress)</h1>
      </template>
      <template #content>
        <Card id="about" class="card">
          <template #title>
            About
          </template>
          <template #content>
            <p>Adventure is a second game made by <b>Mikołaj Tkaczyk</b>.</p>
            <p>This is a different project than <a @click="parkourGameRoute">"Jumpik"</a>
              . In this game you can embody as a warrior. You are able to
              fight with swords!
            </p>
          </template>
        </Card>
        <Card id="lore" class="card">
          <template #title>
            Lore
          </template>
          <template #content>
            <p>You are a adventurer, who wants to earn money and become the best warrior in this word.</p>
            <p>
              You awake in the Forest, you don't remember your name, so you
              are able to choose new. You found a castle, fillfuled of npcs, where you
              get your first mission to hunt on your first enemy.
            </p>
          </template>
        </Card>
        <Card id="features" class="card">
          <template #title>
            Features
          </template>
          <template #content>
            <p>You can:</p>
            <li>Gain experience from enemy, to achive higher level.</li>
            <li>Higher levels allow you to increase selected statistics.</li>
            <li>Drop better equipment.</li>
            <li>Trade with residents or walking vendors.</li>
          </template>
        </Card>
        <Card id="roadMap" class="card">
          <template #title>
            RoadMap
          </template>
          <template #content>
            <p>Add:</p>
            <li>MainHub (castle or something similar).</li>
            <li>Level's system.</li>
            <li>Different enemies and different drop from them.</li>
            <li>Randomly generated maps with missions from quest npc.</li>
            <li>Inventory.</li>
            <li>Different biomes: Forest, Desert, Tundra.</li>
            <li>Building system.</li>
            <li>New Classes: Mage and Archer.</li>
            <li>Skill system (select) </li>
            <li>Perks tree?</li>
            <br>
            <p>Please leave your feedback 
              <a @click="feedbackRoute">here</a>
              , we will be happy from every suggestion!
            </p>
            <p>When we got first alpha version, we will add a redirection here! Stay Tuned!</p>
          </template>
        </Card>
      </template>
    </Card>
  </div>
</template>

<script>
import Card from "primevue/card";

export default {
  components: {
    Card,
  },
  methods: {
    parkourGameRoute() {
      this.$router.push("/parkour")
    },
    feedbackRoute() {
      this.$router.push("/feedback")
    }
  }
}
</script>

<style scoped>
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