<template>
  <div class="border">
    <div class="loginForm">
      <p>Login:</p>
      <div class="field">
        <label for="username">Username: </label>
        <InputText id="username" v-model="userName" type="username" />
      </div>
      <div class="field">
        <label for="password">Password: </label>
        <InputText id="password" v-model="userPassword" type="password"></InputText>
      </div>
      <div>
        <Button
          label="accept"
          class="p-button-primary"
          @click="login"
        />
      </div>
      <div>
        <p class="p" @click="registerRoute">If you dont have an account click <em>here</em></p>
        <p class="p" @click="resetPasswordRoute">If you dont remember password click <em>here</em></p>
      </div>
    </div>
  </div>
</template>

<script>
import InputText from "primevue/inputtext"
import Button from "primevue/button"

export default {
  name: "LoginForm",
  components: {
    InputText,
    Button,
  },
  data() {
    return {
      userName: "",
      userPassword: "",
    }
  },
  computed: {
    loggedIn(){
      return this.$store.state.auth.status.loggedIn;
    },
  },
  created(){
    if (this.loggedIn) {
      this.$router.push("/");
    }
  },
  methods: {
    login(user){
      this.$store.dispatch("auth/login", user).then(
        () => {
          this.$router.push("/");
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
    },
    registerRoute(){
      this.$router.push('/register')
    },
    resetPasswordRoute(){
      this.$router.push('/reset_password')
    }
  }
}
</script>

<style scoped>
.loginForm {
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
.p em {
  color: red;
}
</style>