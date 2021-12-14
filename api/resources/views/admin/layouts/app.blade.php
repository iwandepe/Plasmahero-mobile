<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Website untuk mengelola data pendonor plasma konvalesen">
    <meta name="author" content="Plasmahero Volunteer">
    <title>Plasmahero Admin</title>

    <link rel="icon" href="{{asset("img/favicon.png")}}" type="image/png">

    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700">

    <link rel="stylesheet" href="{{asset("admin-asset/vendor/nucleo/css/nucleo.css")}}" type="text/css">
    <link rel="stylesheet" href="{{asset("admin-asset/vendor/@fortawesome/fontawesome-free/css/all.min.css")}}" type="text/css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <!-- Argon CSS -->
    <link rel="stylesheet" href="{{asset("admin-asset/css/argon.css?v=1.2.0")}}" type="text/css">


    <!-- <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.5.2/css/bootstrap.css" type="text/css"> -->
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.25/css/dataTables.bootstrap4.min.css" type="text/css">
    <link rel="stylesheet" href="https://cdn.datatables.net/buttons/1.7.1/css/buttons.bootstrap4.min.css" type="text/css">

    <link rel="stylesheet" href="{{asset("admin-asset/css/my.css")}}" type="text/css">
</head>

<body>
    <!-- Sidenav -->
    @if ($auth ?? true)

    @include('admin.layouts.sidenav')
    <!-- Main content -->
    <div class="main-content" id="panel">
        <!-- Topnav -->
        @include('admin.layouts.topnav')
        <!-- Header -->
        <div class="header bg-primary pb-6">
            <div class="container-fluid">
                <div class="header-body">
                    <div class="row align-items-center py-4">
                        <div class="col-lg-6 col-7">
                            <h6 class="h2 text-white d-inline-block mb-0">PLASMAHERO.ID</h6>
                            <!-- <nav aria-label="breadcrumb" class="d-none d-md-inline-block ml-md-4">
                                <ol class="breadcrumb breadcrumb-links breadcrumb-dark">
                                    <li class="breadcrumb-item"><a href="/admin"><i class="fas fa-home"></i></a></li>
                                    <li class="breadcrumb-item"><a href="/admin">Data Donor</a></li>
                                    <li class="breadcrumb-item active" aria-current="page"></li> 
                                </ol>
                            </nav> -->
                        </div>

                    </div>
                    <!-- Card stats -->
                    @yield('card-stats')
                </div>
            </div>
        </div>
        <!-- Page content -->
        <div class="container-fluid mt--6">
            @yield('content')
            <!-- Footer -->
            @include('admin.layouts.footer')
        </div>
    </div>
    @else
    @yield('content')
    @endif
    <!-- Core -->
    <script src="{{asset("admin-asset/vendor/jquery/dist/jquery.min.js")}}"></script>
    <script src="{{asset("admin-asset/vendor/bootstrap/dist/js/bootstrap.bundle.min.js")}}"></script>
    <script src="{{asset("admin-asset/vendor/js-cookie/js.cookie.js")}}"></script>
    <script src="{{asset("admin-asset/vendor/jquery.scrollbar/jquery.scrollbar.min.js")}}"></script>
    <script src="{{asset("admin-asset/vendor/jquery-scroll-lock/dist/jquery-scrollLock.min.js")}}"></script>
    <!-- Optional JS -->
    <script src="{{asset("admin-asset/vendor/chart.js/dist/Chart.min.js")}}"></script>
    <script src="{{asset("admin-asset/vendor/chart.js/dist/Chart.extension.js")}}"></script>
    <!-- Argon JS -->
    <script src="{{asset("admin-asset/js/argon.js?v=1.2.0")}}"></script>

    <script src="https://code.jquery.com/jquery-3.5.1.js"></script>
    <script src="https://cdn.datatables.net/1.10.25/js/jquery.dataTables.min.js"></script>
    <script src="https://cdn.datatables.net/1.10.25/js/dataTables.bootstrap4.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.7.1/js/dataTables.buttons.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.bootstrap4.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jszip/3.1.3/jszip.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/pdfmake.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.53/vfs_fonts.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.html5.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.print.min.js"></script>
    <script src="https://cdn.datatables.net/buttons/1.7.1/js/buttons.colVis.min.js"></script>
    <script src="{{asset("admin-asset/js/my.js")}}"></script>
    @yield('script')
</body>

</html>