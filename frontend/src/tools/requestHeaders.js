export default {
    data: function () {
        return {
            headers: {
                'Content-Type': 'application/json',
                "Access-Control-Allow-Origin": "*",
                'Authorization': "Bearer " + localStorage.getItem('token')
            },
        }
    }
}
