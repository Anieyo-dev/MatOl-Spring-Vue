<template>
  <div class="border">
    <div class="registerForm">
      <p>Register:</p>
      <div class="field">
        <label from="userName">Username:</label>
        <InputText id="userName" v-model="userName"></InputText>
      </div>
      <div class="field">
        <label for="userEmail">E-mail: </label>
        <InputText id="userEmail" v-model="userEmail"></InputText>
      </div>
      <div class="field">
        <label for="userPassword">Password:</label>
        <InputText id="userPassword" v-model="userPassword"></InputText>
      </div>
      <div class="field">
        <label for="userPasswordRepeat">Repeat Password: </label>
        <InputText id="userPasswordRepeat" v-model="userPasswordRepeat"></InputText>
      </div>
      <Button 
        label="Register"
        class="p-button-primary"
        @click="register"
      />
    </div>
  </div>
</template>

<script>
import InputText from "primevue/inputtext";
import Button from "primevue/button";

export default {
  name: "RegisterForm",
  components: {
    InputText,
    Button,
  },
  data() {
    return {
      userName: "",
      userEmail: "",
      userPassword:"",
      userPasswordRepeat:"",
    }
  },
  computed: {
    loggedIn() {
      return this.$store.state.auth.status.loggedIn;
    },
  },
  mounted() {
    if (this.loggedIn) {
      this.$router.push("/");
    }
  },
  methods: {
    register(user) {
      this.$store.dispatch("auth/register", user).then(
        (data) => {
          this.message = data.message;
          this.$router.push("/login");
        },
        (error) => {
          this.message =
            (error.response &&
              error.response.data &&
              error.response.data.message) ||
            error.message ||
            error.toString();
        }
      )
    }
  }
}
</script>

<style scoped>
.registerForm {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-left: 10px;
  margin-right: 10px;
  margin-bottom: 10px;
  gap: 10px;
  
}
.border {
  border: solid 1px;
  border-radius: 8px;
}
.field {
  display: flex;
  flex-direction: column;
  
}
</style>