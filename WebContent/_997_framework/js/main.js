// 初始化拿掉了...

var login_Nav =				function () {
					$('#nav-login').hide();
					$('#nav-signup').hide();
					$('.nav-pic').show().css("display", "block");
					$('#nav-myinbox-btn').show().css("display", "block");
					$('#nav-my-member-link').show().css("display", "block");
					$('#nav-logout').show().css("display", "block");
				} ;

//登出後nav-bar右上角的顯示

var logout_Nav =function () {
					$('#nav-login').show().css("display", "block");
					$('#nav-signup').show().css("display", "block");
					$('.nav-pic').hide();
					$('#nav-myinbox-btn').hide();
					$('#nav-my-member-link').hide();
$('#nav-logout').hide()};
//close modal
var close_modal = function() {
    $('.user-modal').removeClass('is-visible');
};




jQuery(document).ready(function($) {
    var pic_base64 = '';
    //------變數------------
    var formModal = $('.user-modal');
        formLogin = formModal.find('#login'),
        formSignup = formModal.find('#signup'),
        formForgotPassword = formModal.find('#reset-password'),
        formModalTab = $('.switcher'),
        tabLogin = formModalTab.children('li').eq(0).children('a'),
        tabSignup = formModalTab.children('li').eq(1).children('a'),
        forgotPasswordLink = formLogin.find('.form-bottom-message a'),
        backToLoginLink = formForgotPasssword.find('.form-bottom-message a'),
        mainNav = $('.main-nav'),
        navRight = $('.nav'),
        signupEmail = $('#signup-email'),
        signupPassword = $('#signup-password'),
        loginEmail = $('#signin-email'),
        loginPassword = $('#signin-password'),
        passwordConfirm = $('#signup-password-confirm'),
        termsAccept = $('#accept-terms'),
        regSubmit = $('#reg-submit'),
        loginSubmit = $('#login-submit'),
        mailButton = $('.mail-btn'),main
        memberUpdateButton = $('#update-member'),
        navSignButton = $('#nav-sign-button'),
        navLogoutButton = $('#nav-logout-button'),
        logoutButton = $('.nav-logout'),
        editMemberButton = $('#edit-member-btn'),
        onMyJamButton = $('#my-jam');

    //---------事件處理--------------

    //在頁面刷新時會執行此函式, 此函式前半段是前往/Jam/loadingMember撈資料
    //撈完後執行onMemberLoading(), 也就是讓撈到的會員資料顯示在畫面上


    //---------按註冊後--------------
    regSubmit.on("click", onSignupClick);

    //-------- 按登出後--------------
    logoutButton.on("click", onLogoutClick);
    memberUpdateButton.on("click", () => {
        onMemberUpdateClick().then((arg) => onMemberLoading(arg));
    });
    editMemberButton.on("click", onEditMemberClick);
    //------------------------------
    });
    //---------按下#my-jam時------------
    onMyJamButton.on('click', function() {
        onMemberPageClick(sessionStorage.getItem("LoginId"));
    });

  

    //-------------------------------------

    //open sign-up form
    navRight.on('click', '.signup', signup_selected);
    //open login-form form
    navRight.on('click', '.login', login_selected);


    formModal.on('click', function(event) {
        if ($(event.target).is(formModal) || $(event.target).is('.close-form')) {
            close_modal();
        }
    });
    //close modal when clicking the esc keyboard button
    $(document).keyup(function(event) {
        if (event.which == '27') {
            formModal.removeClass('is-visible');
        }
    });

    //switch from a tab to another
    formModalTab.on('click', function(event) {
        event.preventDefault();
        ($(event.target).is(tabLogin)) ? login_selected(): signup_selected();
    });


    //show forgot-password form 
    forgotPasswordLink.on('click', function(event) {
        event.preventDefault();
        forgot_password_selected();
    });

    //back to login from the forgot-password form
    backToLoginLink.on('click', function(event) {
        event.preventDefault();
        login_selected();
    });
    //註冊密碼不符合規則

    signupPassword.on('keyup', this, password_rule);
    signupPassword.on('keyup', this, submit_able);

    //註冊確認密碼不一致
	
    passwordConfirm.on('keyup', this, password_different);
    passwordConfirm.on('keyup', this, submit_able);

    //勾選同意條款
    termsAccept.on('click', this, submit_able);




    //驗證畫面按確認後回到主畫面
    $('.confirm-button').on('click', function() {
        $('.confirm-success').toggleClass('is-visible');
    });



    function login_selected() {
        navRight.removeClass('is-visible');
        formModal.addClass('is-visible');
        formLogin.addClass('is-selected');
        formSignup.removeClass('is-selected');
        formForgotPassword.removeClass('is-selected');
        tabLogin.addClass('selected');
        tabSignup.removeClass('selected');
        $('#nav-sign-button').removeClass('in').attr('aria-expanded', 'false');
    }

    function signup_selected() {
        navRight.children('ul').removeClass('is-visible');
        formModal.addClass('is-visible');
        formLogin.removeClass('is-selected');
        formSignup.addClass('is-selected');
        formForgotPassword.removeClass('is-selected');
        tabLogin.removeClass('selected');
        tabSignup.addClass('selected');
        $('#nav-sign-button').removeClass('in').attr('aria-expanded', 'false');

    }

    function forgot_password_selected() {
        formLogin.removeClass('is-selected');
        formSignup.removeClass('is-selected');
        formForgotPassword.addClass('is-selected');
    }

    function terms_Ischecked() {
        if (termsAccept.prop("checked")) {
            return true;
        } else {
            return false;
        }
    }

    function submit_able() {
        if (terms_Ischecked() && password_rule() && password_different()) {
            regSubmit.removeAttr('disabled');
        } else {
            regSubmit.attr('disabled', 'disabled');
        }
    }


    function password_rule() {
        var rule = /^(?=.*[0-9])(?=.*[a-zA-Z])([a-zA-Z0-9]).{7,15}$/;
        if (rule.test(signupPassword.val())) {
            signupPassword.next('span').removeClass('is-visible');
            return true;
        } else {
            signupPassword.next('span').addClass('is-visible');
            return false;
        }

    }

    function password_different() {
        if (signupPassword.val() != passwordConfirm.val()) {

            passwordConfirm.next('span').addClass('is-visible');
            return false;
        } else {
            passwordConfirm.next('span').removeClass('is-visible');
            return true;
        }
    }



    