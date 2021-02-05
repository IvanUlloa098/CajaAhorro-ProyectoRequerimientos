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
<title>Caja de Ahorros</title>
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

<script src="/CajaAhorro-ProyectoRequerimientos/js/modernizr.custom.79639.js"></script>
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body class="seo_version">

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
                        <a class="navbar-brand" href="/CajaAhorro-ProyectoRequerimientos/index.html">
                            <img src="/CajaAhorro-ProyectoRequerimientos/images/logo-seo.png" alt="" />
                        </a>
                        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbars-seo" aria-controls="navbars-rs-food" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
                        <div class="collapse navbar-collapse" id="navbars-seo">
                            <ul class="navbar-nav ml-auto">
                                
                                <li class="nav-item active"><a class="nav-link" href="/CajaAhorro-ProyectoRequerimientos/admin/index.html">Inicio Administrador</a></li>
                                <li class="nav-item"><a class="nav-link" href="/CajaAhorro-ProyectoRequerimientos/admin/crearCaja.jsp">Registar Caja</a></li>
                                <li class="nav-item"><a class="nav-link" href="/CajaAhorro-ProyectoRequerimientos/CrearEmpladoController2">Registar Empleado</a></li>
                                <li class="nav-item"><a class="nav-link" href="/CajaAhorro-ProyectoRequerimientos/admin/EditarSocioDatos.jsp">Editar Empleado</a></li>
                                <li class="nav-item"><a class="nav-link" href="/CajaAhorro-ProyectoRequerimientos/CargarSolicitudesController">Aprobar Credito</a></li>
                                <li class="nav-item"><a class="nav-link" href="/CajaAhorro-ProyectoRequerimientos/pricing.html">Perfil</a></li>
                                <li class="nav-item"><a class="nav-link" href="/CajaAhorro-ProyectoRequerimientos/iniciarSesion.html">Cerrar Sesion</a></li>
                                
                            </ul>
                        </div>
                    </div>
                </nav>
            </header>
            <!-- End header -->

            <div id="slider" class="sl-slider-wrapper">

                <div class="sl-slider">

                    <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="-25" data-slice2-rotation="-25" data-slice1-scale="2" data-slice2-scale="2">
                        <div class="sl-slide-inner">
                            <div class="bg-img bg-img-1"></div>
                            <h2>Savings Bank Seven</h2>
                            <blockquote>
                                <p>Etiam felis elit, mollis posuere accumsan ac, dignissim a ligula. Nam ullamcorper ornare tortor sed dapibus. Aliquam ultrices vestibulum sodales. Aenean efficitur massa vel tellus dapibus pellentesque. </p>
                                <a href="#" class="bttn-new">Started Today</a>
                            </blockquote>
                        </div>
                    </div>

                    <div class="sl-slide" data-orientation="vertical" data-slice1-rotation="10" data-slice2-rotation="-15" data-slice1-scale="1.5" data-slice2-scale="1.5">
                        <div class="sl-slide-inner">
                            <div class="bg-img bg-img-2"></div>
                            <h2>Marketing Website</h2>
                            <blockquote>
                                <p>Etiam felis elit, mollis posuere accumsan ac, dignissim a ligula. Nam ullamcorper ornare tortor sed dapibus. Aliquam ultrices vestibulum sodales. Aenean efficitur massa vel tellus dapibus pellentesque. </p>
                                <a href="#" class="bttn-new">Started Today</a>
                            </blockquote>
                        </div>
                    </div>

                    <div class="sl-slide" data-orientation="horizontal" data-slice1-rotation="3" data-slice2-rotation="3" data-slice1-scale="2" data-slice2-scale="1">
                        <div class="sl-slide-inner">
                            <div class="bg-img bg-img-3"></div>
                            <h2>Search engine, Analytics, Traffic</h2>
                            <blockquote>
                                <p>Etiam felis elit, mollis posuere accumsan ac, dignissim a ligula. Nam ullamcorper ornare tortor sed dapibus. Aliquam ultrices vestibulum sodales. Aenean efficitur massa vel tellus dapibus pellentesque. </p>
                                <a href="#" class="bttn-new">Started Today</a>
                            </blockquote>
                        </div>
                    </div>

                    <div class="sl-slide" data-orientation="vertical" data-slice1-rotation="-5" data-slice2-rotation="25" data-slice1-scale="2" data-slice2-scale="1">
                        <div class="sl-slide-inner">
                            <div class="bg-img bg-img-4"></div>
                            <h2>Social Networking</h2>
                            <blockquote>
                                <p>Etiam felis elit, mollis posuere accumsan ac, dignissim a ligula. Nam ullamcorper ornare tortor sed dapibus. Aliquam ultrices vestibulum sodales. Aenean efficitur massa vel tellus dapibus pellentesque. </p>
                                <a href="#" class="bttn-new">Started Today</a>
                            </blockquote>
                        </div>
                    </div>
                </div>
                <!-- /sl-slider -->

                <nav id="nav-dots" class="nav-dots">
                    <span class="nav-dot-current"></span>
                    <span></span>
                    <span></span>
                    <span></span>
                </nav>

            </div>
            <!-- /slider-wrapper -->

            <div id="about" class="section wb nopadtop">
                <div class="container">
                    <div class="row">
                        <div class="col-md-6 m40">
                            <div class="message-box">
                                <h4>SBS Company</h4>
                                <h2>Savings Bank Seven</h2>
                                <p>Es una entidad de credito plena, con libertad y equiparacion operativa completa al resto de las que integran el sistema financiero ecuatoriano. Estan constituidas bajo la forma juridica de fundaciones de naturaleza privada,
                                    con finalidad social y actuación bajo criterios de mercado y revierten un importante porcentaje de los beneficios obtenidos a la sociedad a través de su Obra Social. </p>

                                <p>Las Cajas de Ahorros se caracterizan en la canalizacion del ahorro popular y en la financiacion de las familias y de las peque�as y medianas empresas. Tienen una fuerte raiz local y una densa red de oficinas de ambito regional.
                                    Cajas de Ahorros se mueven en todas sus acciones por un espiritu regenerador, reformista, de asociacion, de innovacion, cooperacion, vinculacion con el ambito territorial y por los valores principales de solidaridad,
                                    cohesion social, responsabilidad social corporativa, independencia, participación y eficiencia. </p>

                            </div>
                            <!-- end messagebox -->
                        </div>
                        <!-- end col -->

                        <div class="col-md-6">
                            <div class="post-media wow fadeIn">
                                <img src="/CajaAhorro-ProyectoRequerimientos/images/about_01.jpg" alt="" class="img-fluid">
                            </div>
                            <!-- end media -->
                        </div>
                        <!-- end col -->

                    </div>
                    <!-- end row -->

                    <div class="row vission-and-mission">
                        <div class="col-md-12">
                            <ul class="nav nav-pills nav-justified" id="myTab" role="tablist">
                                <li class="nav-item"><a class="nav-link active" href="#tab_a" data-toggle="tab">Mision</a></li>
                                <li class="nav-item"><a class="nav-link" href="#tab_b" data-toggle="tab">Vision</a></li>
                            </ul>
                            <div class="tab-content">
                                <div class="tab-pane fade show active" id="tab_a">
                                    <div class="box-inner-m">
                                        <p>Hacer banca desde el ser humano y para el ser humano, trascendiendo hacia una instituacion centrada en las personas, fomentando el habito del ahorro y ofreciendo a nuestros clientes una amplia variedad de productos
                                            y servicios financieros, optimizando nuestros niveles de rentabilidad y liquidez, cumpliendo con los mas altos estandares de calidad de servicio, con el respaldo de nuestro equipo de trabajo altamente motivado
                                            y capacitado, sin dejar a un lado nuestro compromiso con el desarrollo sostenible de la comunidad y el medio ambiente
                                        </p>

                                    </div>
                                </div>
                                <div class="tab-pane fade" id="tab_b">
                                    <div class="box-inner-m">
                                        <p>Ser reconocido como la mejor entidad financiera, a nivel nacional, para hacer realidad los anhelos de la Familia ayudando a crear riquezas económicas y sociales, evitando la exclusión y generando trama social. </p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <hr class="hr1">


                    <!-- end section -->

                    <div id="services" class="section lb">
                        <div class="container-fluid">
                            <div class="container">
                                <div class="section-title text-center">
                                    <h3>Servicios</h3>
                                    <p class="lead">Los objetivos fundacionales de las Cajas son impulsar el desarrollo económico y financiero, evitar la exclusión social y financiera, y extender a toda la sociedad los beneficios de su actividad como empresa..</p>
                                </div>
                                <!-- end title -->
                            </div>
                            <div class="row text-center">
                                <div class="owl-services-seo owl-carousel owl-theme">
                                    <div class="text-center">
                                        <div class="service-widget">
                                            <div class="post-media wow fadeIn">
                                                <img src="/CajaAhorro-ProyectoRequerimientos/images/seo_01.png" alt="" class="img-fluid img-rounded">
                                            </div>
                                            <h3>Movimientos</h3>
                                            <p>Procesos de transferencia de dinero, para corporaciones o particulares, realizados por bancos como depositos, retiros, transferencias.</p>
                                        </div>
                                        <!-- end service -->
                                    </div>
                                    <!-- end col -->

                                    <div class="text-center">
                                        <div class="service-widget">
                                            <div class="post-media wow fadeIn">
                                                <img src="/CajaAhorro-ProyectoRequerimientos/images/seo_02.png" alt="" class="img-fluid img-rounded">
                                            </div>
                                            <h3>Creditos</h3>
                                            <p>Disposición de fondos que un banco acuerda dar, a cambio de unos intereses que se calculan sobre la cifra efectivamente dispuesta</p>
                                        </div>
                                        <!-- end service -->
                                    </div>
                                    <!-- end col -->

                                    <div class="text-center">
                                        <div class="service-widget">
                                            <div class="post-media wow fadeIn">
                                                <img src="/CajaAhorro-ProyectoRequerimientos/images/seo_03.png" alt="" class="img-fluid img-rounded">
                                            </div>
                                            <h3>Reportes</h3>
                                            <p>Informes periodicos de los acontecimientos macroeconómicos o financieros recientes pueden incidir sobre la estabilidad financiera</p>
                                        </div>
                                        <!-- end service -->
                                    </div>
                                    <!-- end col -->

                                    <div class="text-center">
                                        <div class="service-widget">
                                            <div class="post-media wow fadeIn">
                                                <img src="/CajaAhorro-ProyectoRequerimientos/images/seo_04.png" alt="" class="img-fluid img-rounded">
                                            </div>
                                            <h3>Planes de Cuentas</h3>
                                            <p>El plan de cuentas o planes bancarios, se refiere a un listado que refleja las cuentas para registrar los hechos contables.</p>
                                        </div>
                                        <!-- end service -->
                                    </div>
                                    <!-- end col -->

                                    <div class="text-center">
                                        <div class="service-widget">
                                            <div class="post-media wow fadeIn">
                                                <img src="/CajaAhorro-ProyectoRequerimientos/images/seo_05.png" alt="" class="img-fluid img-rounded">
                                            </div>
                                            <h3>Libro Diario</h3>
                                            <p>Registro contable del sistema financiero en el cual se estructuran todas las operaciones que hagas y que involucren dinero. </p>
                                        </div>
                                        <!-- end service -->
                                    </div>
                                    <!-- end col -->

                                    <!-- end col -->
                                </div>
                                <!-- end col -->
                            </div>
                            <!-- end row -->
                        </div>
                        <!-- end container -->
                    </div>
                    <!-- end section -->

                    <div class="parallax section lb">
                        <div class="container">
                            <div class="row text-center stat-wrap">
                                <div class="col-md-3 col-sm-6 col-xs-12">
                                    <span data-scroll class="global-radius icon_wrap effect-1"><i class="flaticon-briefcase"></i></span>
                                    <p class="stat_count">1200</p>
                                    <h3>Complated Projects</h3>
                                </div>
                                <!-- end col -->

                                <div class="col-md-3 col-sm-6 col-xs-12">
                                    <span data-scroll class="global-radius icon_wrap effect-1"><i class="flaticon-happy"></i></span>
                                    <p class="stat_count">3210</p>
                                    <h3>Happy Clients</h3>
                                </div>
                                <!-- end col -->

                                <div class="col-md-3 col-sm-6 col-xs-12">
                                    <span data-scroll class="global-radius icon_wrap effect-1"><i class="flaticon-idea"></i></span>
                                    <p class="stat_count">3781</p>
                                    <h3>Customer Services</h3>
                                </div>
                                <!-- end col -->

                                <div class="col-md-3 col-sm-6 col-xs-12">
                                    <span data-scroll class="global-radius icon_wrap effect-1"><i class="flaticon-customer-service"></i></span>
                                    <p class="stat_count">4300</p>
                                    <h3>Answered Questions</h3>
                                </div>
                                <!-- end col -->
                            </div>
                            <!-- end row -->
                        </div>
                        <!-- end container -->
                    </div>
                    <!-- end section -->


                    <!-- end section -->

                    <div id="testimonials" class="section wb">
                        <div class="container">
                            <div class="section-title text-center">
                                <h3>Happy Clients</h3>
                                <p class="lead">We thanks for all our awesome testimonials! There are hundreds of our happy customers! <br>Let's see what others say about Landigoo website template!</p>
                            </div>
                            <!-- end title -->

                            <div class="row">
                                <div class="col-md-12 col-sm-12">
                                    <div class="testi-carousel owl-carousel owl-theme">
                                        <div class="testimonial clearfix">
                                            <div class="testi-meta">
                                                <img src="/CajaAhorro-ProyectoRequerimientos/images/testi_01.png" alt="" class="img-fluid alignleft">
                                                <h4>James Fernando <small>- Manager of Racer</small></h4>
                                            </div>
                                            <!-- end testi-meta -->
                                            <div class="desc">
                                                <h3><i class="fa fa-quote-left"></i> Wonderful Support! <i class="fa fa-quote-right"></i></h3>
                                                <p>They have got my project on time with the competition with a sed highly skilled, and experienced & professional team.</p>
                                            </div>
                                        </div>
                                        <!-- end testimonial -->

                                        <div class="testimonial clearfix">
                                            <div class="testi-meta">
                                                <img src="/CajaAhorro-ProyectoRequerimientos/images/testi_02.png" alt="" class="img-fluid alignleft">
                                                <h4>Jacques Philips <small>- Designer</small></h4>
                                            </div>
                                            <!-- end testi-meta -->
                                            <div class="desc">
                                                <h3><i class="fa fa-quote-left"></i> Awesome Services! <i class="fa fa-quote-right"></i></h3>
                                                <p>Explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you completed.</p>
                                            </div>
                                        </div>
                                        <!-- end testimonial -->

                                        <div class="testimonial clearfix">
                                            <div class="testi-meta">
                                                <img src="/CajaAhorro-ProyectoRequerimientos/images/testi_03.png" alt="" class="img-fluid alignleft">
                                                <h4>Venanda Mercy <small>- Newyork City</small></h4>
                                            </div>
                                            <!-- end testi-meta -->
                                            <div class="desc">
                                                <h3><i class="fa fa-quote-left"></i> Great & Talented Team! <i class="fa fa-quote-right"></i></h3>
                                                <p>The master-builder of human happines no one rejects, dislikes avoids pleasure itself, because it is very pursue pleasure. </p>
                                            </div>
                                        </div>
                                        <!-- end testimonial -->
                                        <div class="testimonial clearfix">
                                            <div class="testi-meta">
                                                <img src="/CajaAhorro-ProyectoRequerimientos/images/testi_01.png" alt="" class="img-fluid alignleft">
                                                <h4>James Fernando <small>- Manager of Racer</small></h4>
                                            </div>
                                            <!-- end testi-meta -->
                                            <div class="desc">
                                                <h3><i class="fa fa-quote-left"></i> Wonderful Support! <i class="fa fa-quote-right"></i></h3>
                                                <p>They have got my project on time with the competition with a sed highly skilled, and experienced & professional team.</p>
                                            </div>
                                        </div>
                                        <!-- end testimonial -->

                                        <div class="testimonial clearfix">
                                            <div class="testi-meta">
                                                <img src="/CajaAhorro-ProyectoRequerimientos/images/testi_02.png" alt="" class="img-fluid alignleft">
                                                <h4>Jacques Philips <small>- Designer</small></h4>
                                            </div>
                                            <!-- end testi-meta -->
                                            <div class="desc">
                                                <h3><i class="fa fa-quote-left"></i> Awesome Services! <i class="fa fa-quote-right"></i></h3>
                                                <p>Explain to you how all this mistaken idea of denouncing pleasure and praising pain was born and I will give you completed.</p>
                                            </div>
                                        </div>
                                        <!-- end testimonial -->

                                        <div class="testimonial clearfix">
                                            <div class="testi-meta">
                                                <img src="/CajaAhorro-ProyectoRequerimientos/images/testi_03.png" alt="" class="img-fluid alignleft">
                                                <h4>Venanda Mercy <small>- Newyork City</small></h4>
                                            </div>
                                            <!-- end testi-meta -->
                                            <div class="desc">
                                                <h3><i class="fa fa-quote-left"></i> Great & Talented Team! <i class="fa fa-quote-right"></i></h3>
                                                <p>The master-builder of human happines no one rejects, dislikes avoids pleasure itself, because it is very pursue pleasure. </p>
                                            </div>
                                        </div>
                                        <!-- end testimonial -->
                                    </div>
                                    <!-- end carousel -->
                                </div>
                                <!-- end col -->
                            </div>
                            <!-- end row -->
                        </div>
                        <!-- end container -->
                    </div>
                    <!-- end section -->

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
                            </div>
                            <!-- end row -->
                        </div>
                        <!-- end container -->
                    </div>
                    <!-- end section -->

                    <footer class="footer">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-4 col-md-6 col-xs-12">
                                    <div class="widget clearfix">
                                        <div class="widget-title">
                                            <img src="/CajaAhorro-ProyectoRequerimientos/images/logo-light.png" alt="">
                                        </div>
                                        <p> SEO Mauris pharetra quam ut commodo malesuada. Sed a ornare purus, nec cursus tortor. Integer vehicula felis nec nunc pulvinar efficitur. In et semper odio. Sed laoreet ullamcorper augue, ut mattis metus mattis
                                            quis.
                                        </p>
                                        <p>Sed fermentum est vitae rhoncus molestie. Cum sociis natoque penatibus et magnis dis montes.</p>
                                    </div>
                                    <!-- end clearfix -->
                                </div>
                                <!-- end col -->

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
                                        </ul>
                                        <!-- end links -->
                                    </div>
                                    <!-- end clearfix -->
                                </div>
                                <!-- end col -->

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
                                        </ul>
                                        <!-- end links -->
                                    </div>
                                    <!-- end clearfix -->
                                </div>
                                <!-- end col -->

                                <div class="col-lg-3 col-md-6 col-xs-12">
                                    <div class="widget clearfix">
                                        <div class="widget-title">
                                            <h3>Contact Details</h3>
                                        </div>

                                        <ul class="footer-links">
                                            <li><a href="mailto:#">cajaahorros@gmail.com</a></li>
                                            <li><a href="#">www.yoursite.com</a></li>
                                            <li>PO Box 16122 Collins Street West Victoria 8007 Australia</li>
                                            <li>+61 3 8376 6284</li>
                                        </ul>
                                        <!-- end links -->
                                    </div>
                                    <!-- end clearfix -->
                                </div>
                                <!-- end col -->

                            </div>
                            <!-- end row -->
                        </div>
                        <!-- end container -->
                    </footer>
                    <!-- end footer -->

                    <div class="copyrights">
                        <div class="container">
                            <div class="footer-distributed">
                                <div class="footer-left">
                                    <p class="footer-company-name">All Rights Reserved. &copy; 2018 <a href="#">GreatSEO</a> Design By : <a href="https://html.design/">html design</a></p>
                                </div>
                            </div>
                        </div>
                        <!-- end container -->
                    </div>
                    <!-- end copyrights -->

                    <a href="#" id="scroll-to-top" class="dmtop global-radius"><i class="fa fa-angle-up"></i></a>

                    <!-- ALL JS FILES -->
                    <script src="/CajaAhorro-ProyectoRequerimientos/js/all.js"></script>
                    <!-- ALL PLUGINS -->
                    <script src="/CajaAhorro-ProyectoRequerimientos/js/tippy.all.min.js"></script>
                    <script src="/CajaAhorro-ProyectoRequerimientos/js/custom.js"></script>

                    <script src="/CajaAhorro-ProyectoRequerimientos/js/jquery.ba-cond.min.js"></script>
                    <script src="/CajaAhorro-ProyectoRequerimientos/js/jquery.slitslider.js"></script>
                    <script type="text/javascript">
                        $(function() {

                            var Page = (function() {

                                var $nav = $('#nav-dots > span'),
                                    slitslider = $('#slider').slitslider({
                                        onBeforeChange: function(slide, pos) {

                                            $nav.removeClass('nav-dot-current');
                                            $nav.eq(pos).addClass('nav-dot-current');

                                        }
                                    }),

                                    init = function() {

                                        initEvents();

                                    },
                                    initEvents = function() {

                                        $nav.each(function(i) {

                                            $(this).on('click', function(event) {

                                                var $dot = $(this);

                                                if (!slitslider.isActive()) {

                                                    $nav.removeClass('nav-dot-current');
                                                    $dot.addClass('nav-dot-current');

                                                }

                                                slitslider.jump(i + 1);
                                                return false;

                                            });

                                        });

                                    };

                                return {
                                    init: init
                                };

                            })();

                            Page.init();

                        });
                    </script>

                    <script>
                        tippy('.btn-a')
                    </script>


        </body>

        </html>