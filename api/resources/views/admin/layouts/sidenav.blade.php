<nav class="sidenav navbar navbar-vertical  fixed-left  navbar-expand-xs navbar-light bg-white" id="sidenav-main">
  <div class="scrollbar-inner">
    <div class="sidenav-header  align-items-center mt-3">
      <a class="navbar-brand" href="javascript:void(0)">
        <img src="{{asset("img/logo.png")}}" class="navbar-brand-img" alt="">
      </a>
    </div>
    <div class="navbar-inner">
      <div class="collapse navbar-collapse" id="sidenav-collapse-main">
        <ul class="navbar-nav">
          <li class="nav-item dashboard">
            <a class="nav-link" href="{{ route('dashboard') }}">
              <i class="ni ni-tv-2 text-default"></i>
              <span class="nav-link-text">Dashboard</span>
            </a>
          </li>
          <li class="nav-item donor">
            <a class="nav-link" href="{{ route('donors') }}">
              <i class="ni ni-favourite-28 text-default"></i>
              <span class="nav-link-text">Data Pendonor</span>
            </a>
          </li>
          <li class="nav-item recipient">
            <a class="nav-link" href="{{ route('recipients') }}">
              <i class="ni ni-favourite-28 text-default"></i>
              <span class="nav-link-text">Data Penerima</span>
            </a>
          </li>
        </ul>
        <ul class="navbar-nav">
          <li class="nav-item history">
            <a class="nav-link" href="{{ route('donor-history') }}">
              <i class="fa fa-history  text-default"></i>
              <span class="nav-link-text">Riwayat Donor</span>
            </a>
          </li>
        </ul>
      </div>
    </div>
  </div>
</nav>