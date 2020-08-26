let defaultConfig = require("./config/default.js");
let config = defaultConfig.default;

let apiConfig = config;

try {
    let override = require("./config/override.js");
    apiConfig = {...config, ...override.default};
} catch (e) {
    // no override found, but that's ok
}
// prepend the protocol
apiConfig.apiUrl = window.location.protocol + "//" + apiConfig.apiUrl;
apiConfig.appUrl = window.location.protocol + "//" + apiConfig.appUrl;

export default apiConfig;

