<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Library.com</title>
    <link rel="stylesheet" href="welc.css">
    <link rel="stylesheet" href="login_signup_modal.css">
    <link rel="stylesheet" href="services.css">
    <link rel="stylesheet" href="feedback.css">
    <link rel="stylesheet" href="contact.css">
    <link rel="stylesheet" href="go_to_top.css">
    <link href="https://fonts.googleapis.com/css2?family=Baloo+Bhaina+2&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css"
        integrity="sha384-wvfXpqpZZVQGK6TAh5PVlGOfQNHSoD2xbE+QkPxCAFlNEevoEH3Sl0sibVcOQVnN" crossorigin="anonymous">


</head>

<body>
   <!-- ! HEADER SECTION -->
    <header class=firstpage>
        <div class="burger">
            <div class="line"></div>
            <div class="line"></div>
            <div class="line"></div>
        </div>
        <div class="hotellogo">
            <img src="/logo/logo--Taj.png" alt="">
        </div>

        

        <section class="landingpage background">
            <div class="boxmain">
                <div class="firsthalf">
                     <h2 class="sec1">Welcome to Open Knowledge</h2>
                    <p class="sec1">Enjoy a luxury experience in which your Knowledge will last forever, finest in learning.</p>
               
                </div>

                <div >
                    <button id="login" class="login-signup-button">Login</button>
                    <button id="signup" class="login-signup-button">Sign Up</button>
               
                </div>
            </div>
        </section>
    </header>
    
     <!-- ! MODAL for LOGIN and SIGN-UP -->
    <div class="modal" id="modal1">
        <div class="login-modal">
            <h1>Login</h1>
            <span class="close"  id="login-close">X</span>
            <form action="./main/validatelibrarian" method="post" class="login-form">
                <label for="login-username" class="modallabel">User Name</label>
                <input type="text" name="name" id="login-username" required>
                <label for="login-password" class="modallabel">PassWord</label>
                <input type="password" name="password" id="login-password" required>
                <input type="submit" id="login-submit" value="Login">
            </form>
        </div>
    </div>
    <div class="modal" id="modal2">
        <div class="signin-modal">
            <h1>Sign Up</h1>
            <span class="close" id="signin-close">X</span>
            <form method="post" action="./main/addlibrarian" class="signin-form">
                <label for="signin-username" class="modallabel">User Name</label>
                <input type="text" name="signin-username" id="signin-username" required>
                <label for="signin-password" class="modallabel">PassWord</label>
                <input type="password" name="signin-password" id="signin-password" required>
                <label for="signin-confirm-password" class="modallabel">Confirm PassWord</label>
                <input type="password" name="signin-confirm-password" id="signin-confirm-password" required>
                <input type="submit" id="signin-submit" value="Signin">
            </form>
        </div>
    </div>
    
    
      <!-- ! CONTACT SECTION -->
    <section class="contact" id="contact">
        <div class="hr2">
            <hr class="hrlinetwo">
        </div>
        <h2>Contact US</h2>
        <div class="heading-contact">
        </div>
        <div class="contact-main">
            <div class="contact-info">
                <div class="infobox">
                    <div class="icon"><i class="fa fa-map-marker" aria-hidden="true"></i></div>
                    <div class="text">
                        <h3>Address</h3>
                        <p style='color: black'>1136 SW 1<sup>st</sup> Ave, Miami, FL 33480, United States</p>
                    </div>
                </div>
                <div class="infobox">
                    <div class="icon"><i class="fa fa-phone" aria-hidden="true"></i></div>
                    <div class="text">
                        <h3>Phone</h3>
                        <p style='color: black'>+1 786-266-4900</p>
                    </div>
                </div>
                <div class="infobox">
                    <div class="icon"><i class="fa fa-envelope-o" aria-hidden="true"></i></div>
                    <div class="text">
                        <h3>Email</h3>
                        <p style='color: black'>openknowledge@gmail.com</p>
                    </div>
                </div>
            </div>

            <div class="contact-form">
                <form action="">
                    <h2>Send Message</h2>
                    <div class="inputBox">
                        <input type="text" name="customer-name" id="customer-name" required>
                        <span>Full Name</span>
                    </div>
                    <div class="inputBox">
                        <input type="email" name="customer-email" id="customer-email" required>
                        <span>Email</span>
                    </div>
                    <div class="inputBox">
                        <textarea name="customer-message" id="customer-message" required></textarea>
                        <span>Your Message</span>
                    </div>
                    <div class="inputBox">
                        <input type="submit" name="submit" value="SEND">
                    </div>
                </form>
            </div>
        </div>
    </section>

    <!-- ! FOOTER SECTION -->
    <footer class="footer">
        <div class="socialmedia">
            
            <div class="logos">
                <img src="logo/twitter.png" alt="twitter" class="iconf">
                <img src="logo/whatsapp.png" alt="whatsapp" class="iconf">
                <img src="logo/facebook.png" alt="facebook" class="iconf">
                <img src="logo/instagram.png" alt="insta" class="iconf">
            </div>
        </div>
        <p> Copyright &copy 2023-www.openknowledge.com-Library Of India</p>
    </footer>
    
    
    
     <!-- ! GO_TO_TOP SECTION -->
    <div class="top">
        <a href="#firstpage"><img src="logo/button.png" alt="TOP"></a>
    </div>
    
    
   
    <script src="index.js"></script>
    <script src="login_signup_modal.js"></script>
    
    
</body>

</html>