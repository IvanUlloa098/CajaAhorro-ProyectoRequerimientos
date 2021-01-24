<?xml version="1.0" encoding="ISO-8859-1" ?>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

    <!-- Basic -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">   
   
    <!-- Mobile Metas -->
    <meta name="viewport" content="width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
 
     <!-- Site Metas -->
    <title>Registar CuentaAhorros</title>  
    <meta name="keywords" content="">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- Site Icons -->
    <link rel="shortcut icon" href="/CajaAhorro-ProyectoRequerimientos/images/favicon.ico" type="image/x-icon" />
    <link rel="apple-touch-icon" href="/CajaAhorro-ProyectoRequerimientos/images/apple-touch-icon.png">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="/CajaAhorro-ProyectoRequerimientos/css/bootstrap.min.css">
    <!-- Site CSS -->
    <link rel="stylesheet" href="/CajaAhorro-ProyectoRequerimientos/style.css">
    <!-- ALL VERSION CSS -->
    <link rel="stylesheet" href="/CajaAhorro-ProyectoRequerimientos/css/versions.css">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="/CajaAhorro-ProyectoRequerimientos/css/responsive.css">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="/CajaAhorro-ProyectoRequerimientos/css/custom.css">

    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="seo_version">
	<c:set var="tip" scope="request" value="${tipos}" />
	<c:set var="cajid" scope="session" value="${caja_id}" />

    <!-- LOADER -->
	<div id="preloader">
		<div class="loader-wrapper">
			<div class="loader-new">
				<div class="ball"></div>
				<div class="ball"></div>
				<div class="ball"></div>
			</div>
			<div class="text">LOADING...</div>
		</div>
	</div>
	<!-- END LOADER -->

    <!-- Start header -->
	<header class="top-navbar">
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container">
				<a class="navbar-brand" href="index.html">
					<img src="/CajaAhorro-ProyectoRequerimientos/images/logo-seo.png" alt="" />
				</a>
				<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-seo" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
				  <span class="navbar-toggler-icon"></span>
				</button>
				<div class="collapse navbar-collapse" id="navbars-seo">
					<ul class="navbar-nav ml-auto">
						<li class="nav-item"><a class="nav-link" href="index.html">Home</a></li>
						<li class="nav-item"><a class="nav-link" href="about.html">About Us</a></li>
						<li class="nav-item"><a class="nav-link" href="case-study.html">Case Study</a></li>
						<li class="nav-item dropdown">
							<a class="nav-link dropdown-toggle" href="#" id="dropdown-a" data-toggle="dropdown">Services </a>
							<div class="dropdown-menu" aria-labelledby="dropdown-a">
								<a class="dropdown-item" href="services.html">Search Engine Optimization</a>
								<a class="dropdown-item" href="services.html">Reporting</a>
								<a class="dropdown-item" href="services.html">Email Marketing</a>
								<a class="dropdown-item" href="services.html">Website Development</a>
								<a class="dropdown-item" href="services.html">Social Media Marketing</a>
								<a class="dropdown-item" href="services.html">Pay Per Click</a>
							</div>
						</li>						
						<li class="nav-item"><a class="nav-link" href="pricing.html">Pricing</a></li>
						<li class="nav-item active"><a class="nav-link" href="contact.html">Contact</a></li>
					</ul>
				</div>
			</div>
		</nav>
	</header>
	<!-- End header -->
	<!-- end section -->

    <div id="services" class="section lb">
        <div class="container-fluid">
			<div class="container">
				<div class="row">
					<div class="section-title text-center">
						<h3>Realizar un Depósito</h3>
						<p>Con la cuenta de ahorros de Savings Bank Seven podras manejar tu dinero de manera facil y segura</p>
						<p>Ahora manejar tu cuenta de ahorros es mas practico y eficiente. Puedes acceder, realizar pagos, consultas, retiros y transferencias de forma facil y segura </p>
					</div><!-- end title -->
					<form id="contactform04" class="container"  method="POST" action="/CajaAhorro-ProyectoRequerimientos/RealizarTransaccionController" name="contactform">
                            <fieldset>
                            <fieldset class="row row-fluid">
                            <legend>Informacion Necesaria</legend>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">                                	
                                    <input type="text" name="cuenta" id="cuenta" class="form-control" placeholder="Numero de Cuenta...">
                                </div>
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <input type="number" name="monto" id="monto" class="form-control" placeholder="Monto del Movimiento...">
                                </div>
                                <br><BR />                               
                                
                                <div class="col-lg-6 col-md-6 col-sm-6 col-xs-12">
                                    <SELECT name="plan" class="form-control">
										 <option value= "Tipo de Movimiento" selected >Seleccione el Tipo de Movimiento</option>
										 <c:forEach var="t" items="${tip}">
												 <option value="${t.getId()}">${t.getNombre()}</option>
									        </c:forEach>
								     </SELECT>
                                </div>
                                
                            </fieldset>
                            
                            <input class="container" type="submit" id="login" name="login" value="Realizar Movimiento" />
                            <br><BR />
                          </fieldset>      
                        </form>
				</div>

    <div id="support" class="section db">
        <div class="container">
            <div class="row">
                <div id="logo-carousel" class="owl-carousel">
					<div> <img src="/CajaAhorro-ProyectoRequerimientos/images/logo_01.png" alt=""> </div>
					<div> <img src="/CajaAhorro-ProyectoRequerimientos/images/logo_02.png" alt=""> </div>
					<div> <img src="/CajaAhorro-ProyectoRequerimientos/images/logo_03.png" alt=""> </div>
					<div> <img src="/CajaAhorro-ProyectoRequerimientos/images/logo_04.png" alt=""> </div>
					<div> <img src="/CajaAhorro-ProyectoRequerimientos/images/logo_05.png" alt=""> </div>
					<div> <img src="/CajaAhorro-ProyectoRequerimientos/images/logo_06.png" alt=""> </div>
					<div> <img src="/CajaAhorro-ProyectoRequerimientos/images/logo_01.png" alt=""> </div>
					<div> <img src="/CajaAhorro-ProyectoRequerimientos/images/logo_02.png" alt=""> </div>
				</div>
            </div><!-- end row -->
        </div><!-- end container -->
    </div><!-- end section -->

	<footer class="footer">
        <div class="container">
            <div class="row">
                <div class="col-lg-4 col-md-6 col-xs-12">
                    <div class="widget clearfix">
                        <div class="widget-title">
                            <img src="/CajaAhorro-ProyectoRequerimientos/images/logo-light.png" alt="">
                        </div>
                        <p> SEO Mauris pharetra quam ut commodo malesuada. Sed a ornare purus, nec cursus tortor. Integer vehicula felis nec nunc pulvinar efficitur. In et semper odio. Sed laoreet ullamcorper augue, ut mattis metus mattis quis.</p>
                        <p>Sed fermentum est vitae rhoncus molestie. Cum sociis natoque penatibus et magnis dis montes.</p>
                    </div><!-- end clearfix -->
                </div><!-- end col -->
				
				<div class="col-lg-2 col-md-6 col-xs-12">
                    <div class="widget clearfix">
                        <div class="widget-title">
                            <h3>Information</h3>
                        </div>
                        <ul class="footer-links">
                            <li><a href="#">Home</a></li>
                            <li><a href="#">Blog</a></li>
                            <li><a href="#">Pricing</a></li>
							<li><a href="#">About</a></li>
							<li><a href="#">Faq</a></li>
							<li><a href="#">Contact</a></li>
                        </ul><!-- end links -->
                    </div><!-- end clearfix -->
                </div><!-- end col -->

                <div class="col-lg-3 col-md-6 col-xs-12">
                    <div class="widget clearfix">
						<div class="widget-title">
							<h3>Newsletter</h3>
						</div>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Etiam et tincidunt risus, vitae sollicitudin tellus.</p>
						<div class="news-box">
							<form action="#" method="post">
								<div class="form-group">
									<input class="form-control" placeholder="Email address" type="email">
									<button type="submit">
										<svg id="Layer_11" data-name="Layer 11" xmlns="http://www.w3.org/2000/svg" viewBox="0 0 25.19 17.71">
											<path class="cls-1" d="M311,387.93a.89.89,0,0,0-1.27,1.26l6.44,6.44H295a.89.89,0,0,0-.89.89.9.9,0,0,0,.89.9h21.24l-6.44,6.42a.91.91,0,0,0,0,1.27.89.89,0,0,0,1.27,0l8-8a.87.87,0,0,0,0-1.25Z" transform="translate(-294.08 -387.67)"></path> </svg>
									</button>
								</div>
							</form>
						</div>
						
                        <div class="widget-title">
                            <h3>Social</h3>
                        </div>
                        <ul class="footer-links social-md">
                            <li><a class="fb btn-a" title="Facebook" data-tippy-animation="scale" href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a class="gi btn-a" title="Github" data-tippy-animation="scale" href="#"><i class="fa fa-github"></i> </a></li>
                            <li><a class="tw btn-a" title="Twitter" data-tippy-animation="scale" href="#"><i class="fa fa-twitter"></i> </a></li>
                            <li><a class="dr btn-a" title="Dribbble" data-tippy-animation="scale" href="#"><i class="fa fa-dribbble"></i> </a></li>
                            <li><a class="pi btn-a" title="Pinterest" data-tippy-animation="scale" href="#"><i class="fa fa-pinterest"></i> </a></li>
                        </ul><!-- end links -->
                    </div><!-- end clearfix -->
                </div><!-- end col -->
				
				<div class="col-lg-3 col-md-6 col-xs-12">
                    <div class="widget clearfix">
                        <div class="widget-title">
                            <h3>Contact Details</h3>
                        </div>

                        <ul class="footer-links">
                            <li><a href="mailto:#">info@yoursite.com</a></li>
                            <li><a href="#">www.yoursite.com</a></li>
                            <li>PO Box 16122 Collins Street West Victoria 8007 Australia</li>
                            <li>+61 3 8376 6284</li>
                        </ul><!-- end links -->
                    </div><!-- end clearfix -->
                </div><!-- end col -->
				
            </div><!-- end row -->
        </div><!-- end container -->
    </footer><!-- end footer -->
	
    <div class="copyrights">
        <div class="container">
            <div class="footer-distributed">
                <div class="footer-left">
                    <p class="footer-company-name">All Rights Reserved. &copy; 2018 <a href="#">GreatSEO</a> Design By : <a href="https://html.design/">html design</a></p>
                </div>
            </div>
        </div><!-- end container -->
    </div><!-- end copyrights -->

    <a href="#" id="scroll-to-top" class="dmtop global-radius"><i class="fa fa-angle-up"></i></a>

    <!-- ALL JS FILES -->
    <script src="/CajaAhorro-ProyectoRequerimientos/js/all.js"></script>
	<script src="/CajaAhorro-ProyectoRequerimientos/https://maps.googleapis.com/maps/api/js?libraries=places&key=AIzaSyCKjLTXdq6Db3Xit_pW_GK4EXuPRtnod4o"></script>
	<!-- Mapsed JavaScript -->
	<script src="/CajaAhorro-ProyectoRequerimientos/js/mapsed.js"></script>
	<script src="/CajaAhorro-ProyectoRequerimientos/js/01-custom-places-example.js"></script>
    <!-- ALL PLUGINS -->
    <script src="/CajaAhorro-ProyectoRequerimientos/js/custom.js"></script>
	<script src="/CajaAhorro-ProyectoRequerimientos/js/tippy.all.min.js"></script>
	<script>
		tippy('.btn-a')
	</script>

</body>
</html>