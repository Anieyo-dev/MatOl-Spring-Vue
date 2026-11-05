<template>
  <div class="accountSettingsGrid">
    <div></div>
    <div class="accountSettingsContainer">
      <h3>Account settings</h3>
      <p>Your address e-mail:</p>
      <Button
        id="button"
        type="button"
        class="p-button-raised p-button-text"
        label="Two Factor Security"
      />
      <Button
        id="button"
        type="button"
        class="p-button-raised p-button-text changes"
        label="Change password"
      />
      <Button
        id="button"
        type="button"
        class="p-button-raised p-button-text changes"
        label="Change addres E-mail"
      />
      <Button
          id="button"
          type="button"
          class="p-button-raised p-button-text changes"
          label="Logout"
      />
      <Button
          id="button"
          type="button"
          class="p-button-raised p-button-text danger"
          label="Remove account"
      />
    </div>
  </div>
</template>

<script>
import Button from "primevue/button"
export default {
  name: "AccountSettingsView",
  components: {
    Button,
  }
}
</script>

<style scoped>
.accountSettingsGrid {
  display: grid;
  grid-template-columns: [first] [second] [end];
  justify-content: center;
  justify-items: center;
}

.accountSettingsContainer {
  display: flex;
  flex-direction: column;
  gap: 5px;
  align-items: center;
  background: #fffbf9;
  width: 150%;
  border: 1px purple solid;
  border-radius: 15px;
  padding-bottom: 20px;
  margin-top: 15px;
}

#button {
  color: black;
  width: 80%;
  background: #f1f1f1;
}

#button:hover {
  background: #fffbf9;
}

:deep(#button.danger:hover) {
  background: rgb(255, 81, 81);
}
:deep(#button.changes:hover) {
  background: rgb(235, 235, 33);
}

</style>