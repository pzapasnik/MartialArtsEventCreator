$(document).ready(function{
    var logout = $('#logout')
    var logoutForm = $('#logout-form')

    logout.click(function (e){
        e.preventDefault();
        logoutForm.submit();
    })

})