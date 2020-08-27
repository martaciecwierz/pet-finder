import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import PetList from '../views/Pets/PetList.vue'
import SheltersList from "../views/Shelters/SheltersList";
import PetAdmin from "@/views/Pets/PetAdmin";
import PetTypeAdmin from "@/views/PetTypes/PetTypeAdmin";
import AttributeAdmin from "@/views/Attributes/AttributeAdmin";
import ActionTypeAdmin from "@/views/ActionTypes/ActionTypeAdmin";
import UserAdmin from "@/views/Users/UserAdmin";
import ArticleAdmin from "@/views/Articles/ArticleAdmin";
import CommentAdmin from "@/views/Comments/CommentAdmin";

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: SheltersList
  },{
    path: '/logout',
    name: 'Logout',
    component: Logout
  },
  {
    path: '/login',
    name: 'Login',
    component: Login
  },
  {
    path: '/pets',
    name: 'PetList',
    component: PetList
  },
  {
    path: '/admin/pets',
    name: 'PetAdmin',
    component: PetAdmin
  },
  {
    path: '/admin/articles',
    name: 'ArticleAdmin',
    component: ArticleAdmin
  },
  {
    path: '/admin/comments/:articleId',
    name: 'CommentAdmin',
    component: CommentAdmin
  },
  {
    path: '/admin/pet-types',
    name: 'PetTypesAdmin',
    component: PetTypeAdmin
  },
  {
    path: '/admin/attributes',
    name: 'AtributesAdmin',
    component: AttributeAdmin
  },
  {
    path: '/admin/action-types',
    name: 'ActionTypesAdmin',
    component: ActionTypeAdmin
  },
  {
    path: '/admin/users',
    name: 'UserAdmin',
    component: UserAdmin
  },
  {
    path: '/shelters',
    name: 'SheltersList',
    component: SheltersList
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

export default router
