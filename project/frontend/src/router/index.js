import { createRouter, createWebHistory } from "vue-router";
import DashBoardView from "../views/DashBoardView.vue";
import LoginView from "../views/LoginView.vue";
import RegisterView from "../views/RegisterView.vue";
import ResetPasswordView from "../views/ResetPasswordView.vue";
import AccountSettingsView from "../views/AccountSettingsView.vue";
import Parkour from "../views/Parkour.vue";
import AdventureView from "../views/AdventureView.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "dashboard",
      component: DashBoardView,
    },
    {
      path: "/login",
      name: "login",
      component: LoginView,
    },
    {
      path: "/register",
      name: "register",
      component: RegisterView,
    },
    {
      path:"/reset_password",
      name: "reset_password",
      component: ResetPasswordView,
    },
    {
      path:"/account_settings",
      name: "account_settings",
      component: AccountSettingsView,
    },
    {
      path:"/parkour",
      name: "parkour",
      component: Parkour,
    },
    {
      path:"/adventure",
      name:"adventure",
      component: AdventureView,
    },
    {
      path: "/about",
      name: "about",
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import("../views/AboutView.vue"),
    },
  ],
});

router.beforeEach((to, from, next) => {
  const publicPages = ['/login', '/register', 'reset_password', 'about'];
  const authRequired = !publicPages.includes(to.path);
  const loggedIn = localStorage.getItem('user');
  // trying to access a restricted page + not logged in
  // redirect to login page
  if (authRequired && !loggedIn) {
    next('login');
  }
  else {
    next();
  }
});

export default router;
