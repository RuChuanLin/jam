<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="_997_framework/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="_997_framework/font-awesome-4.7.0/css/font-awesome.min.css">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <link rel="stylesheet" href="_997_framework/css/reset.css">
    <link rel="stylesheet" href="_997_framework/css/style.css">
    <link rel="stylesheet" href="_997_framework/css/queries.css">
    <link rel="stylesheet" href="_997_framework/css/bootstrap-social.css">
    <script src="https://code.jquery.com/jquery-3.1.1.slim.min.js" integrity="sha256-/SIrNqv8h6QGKDuNoLGA4iret+kyesCkHGzVUUV0shc=" crossorigin="anonymous"></script>
    <script src="_997_framework/js/carousel.js"></script>
    <!--  <script src="login.js"></script> -->
    <title>index</title>
</head>

<body>
    <!-- navbar -->
    <nav class="navbar navbar-inverse navbar-fixed-top">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">Jam</a>
            </div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="#"><i class="fa fa-envelope-o" fa-5x aria-hidden="true" ></i><span class="badge">1<span></a></li>
                    <li><a href="#" class="login">登入</a></li>
                    <li><a href="#" class="signup">註冊</a></li>
                </ul>
            </div>
        </div>
    </nav>
    <!-- 主頁面 -->
    <header class="index">
        <!-- 背景區塊 -->
        <div class="bg bg1">
            <!-- backgroung fake button -->
            <div class="bgbt">
                <button type="button" id="bt01" class="btn btn-success btn-lg">
                    找老師
                </button>
            </div>
            <!-- 上層特效 block+button -->
            <div class="block block1">
                <div class="button button1">
                    <button type="button" class="btn btn-success btn-lg">
                        找老師
                    </button>
                </div>
            </div>
        </div>
        <div class="bg bg2">
            <div class="bgbt">
                <button type="button" id="bt01" class="btn btn-success btn-lg">
                    找樂器
                </button>
            </div>
            <div class="block block2">
                <div class="button button2">
                    <button type="button" class="btn btn-success btn-lg">
                        找樂器
                    </button>
                </div>
            </div>
        </div>
        <div class="bg bg3">
            <div class="bgbt">
                <button type="button" id="bt01" class="btn btn-success btn-lg">
                    找團員
                </button>
            </div>
            <div class="block block3">
                <div class="button button3">
                    <button type="button" class="btn btn-success btn-lg">
                        找團員
                    </button>
                </div>
            </div>
        </div>
    </header>
    <!--  email驗證成功，自動登入畫面 -->
    <div class="confirm-success-container">
        <div class="confirm-success">
            <p class="confirm-words">
                已成功註冊，歡迎使用Jam!
            </p>
            <button type="button" class="confirm-button">確認</button>
        </div>
    </div>
    <!-- 登入/註冊畫面 -->
    <div class="cd-user-modal">
        <!-- this is the entire modal form, including the background -->
        <div class="cd-user-modal-container">
            <!-- this is the container wrapper -->
            <ul class="cd-switcher">
                <li><a href="#0">登入</a></li>
                <li><a href="#0">註冊</a></li>
            </ul>
            <div id="cd-login">
                <!-- log in form -->
                <form class="cd-form">
                    <a class="btn btn-block btn-social btn-facebook">
                        <span class="fa fa-facebook"></span> 使用Facebook登入
                    </a>
                    <p class="fieldset">
                        <label class="image-replace cd-email" for="signin-email">E-mail</label>
                        <input class="full-width has-padding has-border" id="signin-email" type="email" placeholder="E-mail">
                        <span class="cd-error-message">Error message here!</span>
                    </p>
                    <p class="fieldset">
                        <label class="image-replace cd-password" for="signin-password">Password</label>
                        <input class="full-width has-padding has-border" id="signin-password" type="text" placeholder="密碼">
                        <a href="#0" class="hide-password">隱藏密碼</a>
                        <span class="cd-error-message">Error message here!</span>
                    </p>
                    <p class="fieldset">
                        <input type="checkbox" id="remember-me" checked>
                        <label for="remember-me">記得我</label>
                    </p>
                    <p class="fieldset">
                        <input class="full-width" type="submit" value="登入">
                    </p>
                </form>
                <p class="cd-form-bottom-message"><a href="#0">忘記密碼?</a></p>
                <!-- <a href="#0" class="cd-close-form">Close</a> -->
            </div>
            <!-- cd-login -->
            <div id="cd-signup">
                <!-- sign up form -->
                <form class="cd-form" action="${pageContext.request.contextPath }/_01_member/controller/register.do" method="post">
                    <a class="btn btn-block btn-social btn-facebook">
                        <span class="fa fa-facebook"></span> 使用Facebook註冊
                    </a>
                    <p class="fieldset">
                        <label class="image-replace cd-email" for="signup-email">E-mail</label>
                        <input class="full-width has-padding has-border" name="account" id="signup-email" type="email" placeholder="E-mail">
                        <span class="cd-error-message">此帳號已被註冊!</span>
                    </p>
                    <p class="fieldset">
                        <label class="image-replace cd-password" for="signup-password">Password</label>
                        <input class="full-width has-padding has-border" name="password" id="signup-password" type="text" placeholder="密碼">
                        <a href="#0" class="hide-password">隱藏密碼</a>
                        <span class="cd-error-message">請使用8位以上的英文+數字組成密碼!</span>
                    </p>
                    <p class="fieldset">
                        <label class="image-replace cd-password" for="signup-password">Password</label>
                        <input class="full-width has-padding has-border" id="signup-password" type="text" placeholder="確認密碼">
                        <a href="#0" class="hide-password">隱藏密碼</a>
                        <span class="cd-error-message">密碼不一致!</span>
                    </p>
                    <p class="fieldset">
                        <input type="checkbox" id="accept-terms">
                        <label for="accept-terms">我同意 <a href="#0" class="terms">使用條款與規範</a></label>
                    </p>
                    <p class="fieldset">
                        <input class="full-width has-padding" type="submit" value="註冊">
                    </p>
                </form>
                <!-- <a href="#0" class="cd-close-form">Close</a> -->
            </div>
            <!-- cd-signup -->
            <div id="cd-reset-password">
                <!-- reset password form -->
                <p class="cd-form-message">忘記密碼?請填入註冊信箱，我們將會寄一組新的密碼給您</p>
                <form class="cd-form">
                    <p class="fieldset">
                        <label class="image-replace cd-email" for="reset-email">E-mail</label>
                        <input class="full-width has-padding has-border" id="reset-email" type="email" placeholder="E-mail">
                        <span class="cd-error-message">Error message here!</span>
                    </p>
                    <p class="fieldset">
                        <input class="full-width has-padding" type="submit" value="重設密碼">
                    </p>
                </form>
                <p class="cd-form-bottom-message"><a href="#0">回到登入畫面</a></p>
            </div>
            <!-- cd-reset-password -->
            <a href="#0" class="cd-close-form">Close</a>
        </div>
        <!-- cd-user-modal-container -->
    </div>
    <!-- cd-user-modal -->
    <!-- 找老師預覽 thumbnails in carousel-->
    <section class="container-fluid text-center" id="teacher-profolio">
        <div class="theme">
            <h1>精選熱門教師</h1>
            <!--  <p>Jam不收取任何仲介費用
            音樂人的免費平台
            打造自由教學風氣</p> -->
        </div>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="well">
                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel">
                            <ol class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="1"></li>
                                <li data-target="#carousel-example-generic" data-slide-to="2"></li>
                            </ol>
                            <!-- Carousel items -->
                            <div class="carousel-inner">
                                <div class="item active">
                                    <div class="row-fluid">
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t01.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t02.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t03.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t04.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/row-fluid-->
                                </div>
                                <!--第二頁-->
                                <div class="item">
                                    <div class="row-fluid">
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t05.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t06.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t07.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t08.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/row-fluid-->
                                </div>
                                <!--第三頁-->
                                <div class="item">
                                    <div class="row-fluid">
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t09.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t10.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t11.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                        <div class="col-md-3">
                                            <a href="#x" class="thumbnail"><img src="_996_image/teacher/t12.jpg" alt="Image" style="max-width:100%;" /></a>
                                            <div class="caption">
                                                <h3>Tim Ray</h3>
                                                <h4>Guitar</h4>
                                                <p><a href="#" class="btn btn-primary" role="button"><i class="fa fa-envelope-o" fa-4x aria-hidden="true" ></i></a> </p>
                                            </div>
                                        </div>
                                    </div>
                                    <!--/row-fluid-->
                                </div>
                                <!--/item-->
                            </div>
                            <!--/carousel-inner-->
                            <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                        <!--/carousel-example-generic-->
                    </div>
                    <!--/well-->
                </div>
            </div>
        </div>
    </section>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="_997_framework/js/main.js"></script>
    <script src="_997_framework/bootstrap/js/bootstrap.min.js"></script>
</body>
</html>