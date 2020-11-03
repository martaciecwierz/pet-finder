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
import ShelterAdmin from "@/views/Shelters/ShelterAdmin";
import UserProfile from "@/views/Users/UserProfile";
import ChangePassword from "@/views/Users/ChangePassword";
import ChangeUserInfo from "@/views/Users/ChangeUserInfo";
import ShelterInfo from "@/views/Shelters/ShelterInfo";
import ShelterPetsList from "@/views/Shelters/ShelterPetsList";
import PetProfile from "@/views/Pets/PetProfile";
import PetRates from "@/views/Pets/PetRates";

Vue.use(VueRouter)

const routes = [
    {
        path: '/',
        name: 'Home',
        component: SheltersList
    }, {
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
        path: '/pets/:id',
        name: 'PetProfile',
        component: PetProfile
    },
    {
        path: '/pets/:id/rates',
        name: 'PetRates',
        component: PetRates
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
        name: 'AttributesAdmin',
        component: AttributeAdmin
    },
    {
        path: '/admin/shelters',
        name: 'SheltersAdmin',
        component: ShelterAdmin
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
        path: '/shelters/:id',
        name: 'ShelterInfo',
        component: ShelterInfo
    },
    {
        path: '/shelters/:id/pets',
        name: 'ShelterPetsList',
        component: ShelterPetsList
    },
    {
        path: '/user',
        name: 'UserProfile',
        component: UserProfile
    },
    {
        path: '/user/password',
        name: 'ChangePassword',
        component: ChangePassword
    },
    {
        path: '/user/edit',
        name: 'ChangeUserInfo',
        component: ChangeUserInfo
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
