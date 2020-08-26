import axios from "axios";
import apiConfig from "@/apiConfig";


export default axios.create({
    baseURL: apiConfig.apiUrl
});

