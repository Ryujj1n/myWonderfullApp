<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="utf-8">
    <title>Student Simulator</title>
    <meta name="description" content="Student Simulator">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="WEB-FILE/style/style.css">
    <link rel="apple-touch-icon" sizes="180x180" href="WEB-FILE/img/apple-touch-icon.png">
    <link rel="icon" type="image/png" sizes="32x32" href="WEB-FILE/img/favicon-32x32.png">
    <link rel="icon" type="image/png" sizes="16x16" href="WEB-FILE/img/favicon-16x16.png">
    <link rel="manifest" href="WEB-FILE/img/site.webmanifest">
    <link rel="canonical" href="http://www.student-simulator.fr/"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.7/css/materialize.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:300' rel='stylesheet' type='text/css'>
    <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
    <style>
        .tabs .indicator {
            background-color: #ff9900;
        }
    </style>
</head>
<body>
    <img class="logo" src="WEB-FILE/img/Student_Simulator.png" alt="Student_Simulator">
    <div class="row container padtop80">
    <div class="col m6 offset-m3 s12">
        <div class="row">
            <div class="col s12">
                <ul class="tabs">
                    <li class="tab col s3"><a href="#part1" class="active black-text text-darken-4">Connexion</a>
                    </li>
                    <li class="tab col s3"><a href="#part2" class="black-text text-darken-4">Inscription</a></li>
                </ul>
            </div>
        </div>
    </div>
    <div id="part1" class="col s12 padtop40">
        <div class="col m6 offset-m3 s12 z-depth-1 padtop10" id="zone1">
            <form>
                <div class="lid">
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">account_circle</i>
                            <input class="validate" id="pseudo-co" type="text" required>
                            <label for="pseudo-co">Pseudo *</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <i class="material-icons prefix">lock_outline</i>
                            <input id="password-co" type="password" required>
                            <label for="password-co">Mot de passe *</label>
                        </div>
                    </div>
                    <div class="row">
                        <button class="btn waves-effect waves-light col s12" type="submit" name="connect"
                                style="background-color: #ff9900">
                            <a href="home.xhtml" style="color: white">Je me connecte !</a>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>
    <div id="part2" class="col s12 padtop40">
        <div class="col m6 offset-m3 s12 z-depth-1 padtop10" id="zone2">
            <form>
                <div class="input-field col s12">
                    <input class="validate" id="pseudo" type="text" required>
                    <label for="pseudo">Pseudo *</label>
                </div>
                <div class="input-field col s12">
                    <label for="password">Mot de passe *</label>
                    <input class="validate" id="password" type="password" minlength="8" maxlength="16" required>
                </div>
                <div class="input-field col s12">
                    <label id="lblPasswordConfirm" for="passwordConfirm">Confirmation du mot de passe *</label>
                    <input id="passwordConfirm" type="password" required>
                </div>
                <p class="padleft10">
                    <label for="checkCondition">J'accepte de perdre et de rager *</label>
                    <input class="check" type="checkbox" id="checkCondition" required/>
                </p>
                <div class="row">
                    <button class="btn waves-effect waves-light col s12" type="submit" name="inscript"
                            style="background-color: #ff9900; margin-top: 2%;">
                        <a href="home.xhtml" style="color: white">Je m'inscris !</a>
                    </button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
<script>
    $(document).ready(function () {
        $(".button-collapse").sideNav();
        $(".dropdown-button").dropdown();
        $('select').material_select();
        $('.slider').slider({full_width: true});
        $(".button-collapse").sideNav();
    })
</script>
<script>
    $(document).ready(function () {
        $(".hid").hide();
        $("#hider").click(function () {
            $(".remx").hide();
            $(".hid").show();
        });
        $("#cancll").click(function () {
            $(".remx").show();
            $(".hid").hide();
        })
    });
</script>
<script>
    $("#password").on("focusout", function (e) {
        if ($(this).val() != $("#passwordConfirm").val()) {
            $("#passwordConfirm").removeClass("valid").addClass("invalid");
        } else {
            $("#passwordConfirm").removeClass("invalid").addClass("valid");
        }
    });

    $("#passwordConfirm").on("keyup", function (e) {
        if ($("#password").val() != $(this).val()) {
            $(this).removeClass("valid").addClass("invalid");
        } else {
            $(this).removeClass("invalid").addClass("valid");
        }
    });
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
</html>