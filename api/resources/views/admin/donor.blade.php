@extends('admin.layouts.app')

@section('card-stats')
<div class="row">
  <div class="col-xl-3 col-md-6">
    <div class="card card-stats">
      <div class="card-body">
        <a href="/admin/datadonor?gol_darah=A">
          <div class="row">
            <div class="col">
              <h5 class="card-title text-uppercase text-muted mb-0">Goldar A</h5>
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
  <div class="col-xl-3 col-md-6">
    <div class="card card-stats">
      <div class="card-body">
        <a href="/admin/datadonor?gol_darah=B">
          <div class="row">
            <div class="col">
              <h5 class="card-title text-uppercase text-muted mb-0">Goldar B</h5>
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
  <div class="col-xl-3 col-md-6">
    <div class="card card-stats">
      <!-- Card body -->
      <div class="card-body">
        <a href="/admin/datadonor?gol_darah=AB">
          <div class="row">
            <div class="col">
              <h5 class="card-title text-uppercase text-muted mb-0">Goldar AB</h5>
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
  <div class="col-xl-3 col-md-6">
    <div class="card card-stats">
      <!-- Card body -->
      <div class="card-body">
        <a href="/admin/datadonor?gol_darah=O">
          <div class="row">
            <div class="col">
              <h5 class="card-title text-uppercase text-muted mb-0">Goldar O</h5>
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

@section('content')
<div class="row">
  <div class="col">
    <div class="card">
      <div class="card-header border-0">
        <div class="container">
          <div class="row">
            <h3>Data Pendonor</h3>
          </div>
        </div>
      </div>
      @if (count($donors) == 0)
      <p class="text-center">Belum ada data</p>
      @else
      <div class="table-responsive">
        <table class="table align-items-center table-flush">
          <thead class="thead-light">
            <tr>
              <th>Nama</th>
              <th>Kota</th>
              <th>Goldar</th>
              <th>Usia</th>
              <th>Kelamin</th>
              <th>Hubungi</th>
              <th></th>
            </tr>
          </thead>
          <tbody class="list">
            @foreach ($donors as $key=>$data)
            <tr>
              <td>{{$data->name}} {{ $data->id }} {{ $data->user_id}}</td>
              <td>{{$data->city}}</td>
              <td>{{$data->blood_type}} {{$data->blood_rhesus}}</td>
              <td>{{$data->age}}</td>
              <td>{{$data->gender}}</td>
              <td><a href="https://wa.me/{{$data->phone}}" class="btn btn-sm btn-success"><i class="fa fa-whatsapp"></i></a></td>
              <td>
                <!-- Button and modal dialog to show donor detail -->
                <button type="button" class="btn btn-sm btn-info mx-auto mb-1" data-toggle="modal" data-target="#donors{{$data->id}}" style="width: 80px;">Detail</button>
                <div class="modal fade" id="donors{{$data->id}}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                  <div class="modal-dialog modal-lg" role="document">
                    <div class="modal-content">
                      <div class="modal-header pb-1">
                        <h5 class="modal-title" id="exampleModalLongTitle">Data Detail Pendonor</h5>
                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                          <span aria-hidden="true">&times;</span>
                        </button>
                      </div>
                      <div class="modal-body py-0">
                        @include('admin.components.donor-detail')
                      </div>
                      <div class="modal-footer">
                      </div>
                    </div>
                  </div>
                </div>

                <!-- Button and modal dialog for donor verification data and confirming -->
                @if (!$data->is_valid)
                <button class="btn btn-sm btn-success mx-auto mb-1" data-toggle="modal" data-target="#verification{{$data->id}}" style="width: 80px;">Verifikasi</button>
                @endif
                <div class="modal fade" id="verification{{$data->id}}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                  <div class="modal-dialog modal-dialog-center" role="document">
                    <div class="modal-content">
                      <div class="modal-header pb-0">
                        <h6 class="modal-title" id="exampleModalLongTitle">Apakah anda yakin?</h6>
                      </div>
                      <div class="modal-footer">
                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Batal</button>

                        <a class="btn btn-success" href="{{ route('donor-verify', ['userId' => $data->user_id]) }}">Verifikasi</a>
                      </div>
                    </div>
                  </div>
                </div>
              </td>
            </tr>
            @endforeach
          </tbody>
        </table>
      </div>
      @endif
    </div>
  </div>
</div>
@endsection

@section('script')
<script>
  $(".donor a").addClass("active");
</script>
@endsection