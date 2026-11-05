<template>
  <div class="form">
    <LoginForm/>
  </div>
</template>

<script>
import LoginForm from "@/components/forms/LoginForm.vue"

export default {
  name: "LoginView",
  components: {
    LoginForm,
  }
}
</script>

<style>
.form {
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 150px;
}
</style>