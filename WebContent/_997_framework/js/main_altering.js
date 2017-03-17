

var index_methods=new Object();

index_methods.index_methods.login_Nav = function() {
    $('#nav-login').hide();
    $('#nav-signup').hide();
    $('.nav-pic').show().css("display", "block");
    $('#nav-myinbox-btn').show().css("display", "block");
    $('#nav-my-member-link').show().css("display", "block");
    $('#nav-logout').show().css("display", "block");

};

//登出後nav-bar右上角的顯示

index_methods.index_methods.logout_Nav = function() {
    $('#nav-login').show().css("display", "block");
    $('#nav-signup').show().css("display", "block");
    $('.nav-pic').hide();
    $('#nav-myinbox-btn').hide();
    $('#nav-my-member-link').hide();
    $('#nav-logout').hide();

};

index_methods.close_modal = function() {
    $('.user-modal').removeClass('is-visible');
};



jQuery(document).ready(function($) {
    //------變數------------
    var formModal = $('.user-modal'),
        formLogin = formModal.find('#login'),
        formSignup = formModal.find('#signup'),
        formForgotPassword = formModal.find('#reset-password'),
        formModalTab = $('.switcher'),
        tabLogin = formModalTab.children('li').eq(0).children('a'),
        tabSignup = formModalTab.children('li').eq(1).children('a'),
        forgotPasswordLink = formLogin.find('.form-bottom-message a'),
        backToLoginLink = formForgotPassword.find('.form-bottom-message a'),
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
        mailButton = $('.mail-btn'),
        memberUpdateButton = $('#update-member'),
        navSignButton = $('#nav-sign-button'),
        navLogoutButton = $('#nav-logout-button'),
        logoutButton = $('.nav-logout'),
        editMemberButton = $('#edit-member-btn'),
        onMyJamButton = $('#my-jam');


	stater.checkState(index_methods.login_Nav,index_methods.logout_Nav);
    regSubmit.on("click", onSignupClick);
    loginSubmit.on("click",onLoginClick);
    logoutButton.on("click", onLogoutClick);
	

    signupEmail.on('keyup', function() {
        console.log(account);
		var re = /^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i;
		var vAcc=document.getElementById(field_ACC).value;
			if(re.test(vAcc)){
					mem.validateAcc(vAcc,function(response){
					  if (response.accExt) {
							signupEmail.next('span').addClass('is-visible');
							  return false;
						 } else {
							signupEmail.next('span').removeClass('is-visible');
						 };	
					});				
			}else{
				signupEmail.next('span').addClass('is-visible');
				console.log("wrong email format");	
			}
    });




    function onSignupClick() {
		
		var rInfo={
			type : "normal",
			acc : signupEmail.val(),
			pw :signupPassword.val()
		}
		mem.register(rInfo,function(resp){
			if(resp.regSuccess){
				index_methods.close_modal()
				alert("Register Success");
					}
				});
        
    }

    // 登入方法，並沒有後半段的顯示會員資料，因為會串接onMemberLoading()登入方法，並沒有後半段的顯示會員資料，因為會串接onMemberLoading
    //來顯示會員資料
    function onLoginClick() {
		
			var info={
				type : "normal",
				acc :loginEmail.val(),
				pw :loginPassword.val()
			};
			
			mem.login(info,function(resp){
				if (response.loginSuccess) {
                    console.log(response);
                    index_methods.index_methods.login_Nav();
                    close_modal();
                    kie.setCookieObj(jam_cookie_key,{ user_id : resp.id, user_alias : resp.alias});
				    stater.checkState(index_methods.login_Nav,index_methods.logout_Nav);
                } else{
					alert("login failed");
				}				
			})

        

    }

	
    function onLogoutClick() {
        //登出畫面，以下寫程式碼
		mem.logout();
		//reload的時候就會觸發 $(document).ready裡的方法重新判斷登入狀態。
        window.location.reload(true);
        return;
    }



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


    signupPassword.on('keyup', this, submit_able);

    //註冊確認密碼不一致
    passwordConfirm.on('keyup', this, password_different);
    passwordConfirm.on('keyup', this, submit_able);

    //勾選同意條款
    termsAccept.on('click', this, submit_able);

	index_methods.chkRegPw=function(){
		
	}



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

    //登入帳密錯誤
    function error_idps() {
        $('#remember-me').append('<div class="error-IdPs"><i class="fa fa-exclamation-triangle" aria-hidden="true"></i></div>');
    }
    // ------------------ajax+servlet整合的畫面function----------------------
    //登入後nav-bar右上角的顯示

    var test1 = $('.test-btn1');
    var test2 = $('.test-btn2');
    var navbarRight = $('.navbar-right');

    test1.click(index_methods.login_Nav);
    test2.click(index_methods.logout_Nav);



    //登入帳密錯誤動畫
    var animationEnd = 'webkitAnimationEnd mozAnimationEnd MSAnimationEnd oanimationend animationend';


});
