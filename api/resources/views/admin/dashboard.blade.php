@extends('admin.layouts.app')

@section('card-stats')
<div class="row">
    <div class="col-xl-6 col-md-6">
        <div class="card card-stats">
            <div class="card-body">
                <a href="/admin/datadonor">
                    <div class="row">
                        <div class="col">
                            <h5 class="card-title text-uppercase text-muted mb-0">Pendonor Plasma Terverifikasi</h5>
                            <span class="h2 font-weight-bold mb-0">100</span>
                        </div>
                        <div class="col-auto">
                            <div class="icon icon-shape bg-gradient-orange text-white rounded-circle shadow">
                                <i class="fa fa-hand-point-down"></i>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>
    <div class="col-xl-6 col-md-6">
        <div class="card card-stats">
            <div class="card-body">
                <a href="/admin/permintaanplasma">
                    <div class="row">
                        <div class="col">
                            <h5 class="card-title text-uppercase text-muted mb-0">Permintaan Plasma Terverifikasi</h5>
                            <span class="h2 font-weight-bold mb-0">100</span>
                        </div>
                        <div class="col-auto">
                            <div class="icon icon-shape bg-gradient-orange text-white rounded-circle shadow">
                                <i class="fa fa-hand-point-down"></i>
                            </div>
                        </div>
                    </div>
                </a>
            </div>
        </div>
    </div>
</div>
@endsection

@section('script')
<script>
    $(".dashboard a").addClass("active");
</script>
@endsection