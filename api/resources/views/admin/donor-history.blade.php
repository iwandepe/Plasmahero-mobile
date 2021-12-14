@extends('admin.layouts.app')

@section('content')
<div class="row">
    <div class="col">
        <div class="card">
            <div class="card-header border-0">
                <h3>Riwayat pendonoran</h3>
            </div>
            @if (count($histories) == 0)
            <p class="text-center">Belum ada data</p>
            @else
            <div>
                <table class="table align-items-center table-flush">
                    <thead class="thead-light">
                        <tr class="d-flex">
                            <th class="col-4">Nama</th>
                            <th class="col-4">Tanggal Donor</th>
                            <th class="col-2">Goldar</th>
                            <th class="col-2"></th>
                        </tr>
                    </thead>
                    <tbody>
                        @foreach($histories as $key=>$data)
                        <tr class="d-flex">
                            <td class="col-4">
                                {{$data->name}}
                            </td>
                            <td class="col-4">
                                {{$data->donor_date}}
                            </td>
                            <td class="col-2">
                                {{$data->blood_type}} {{$data->blood_rhesus}}
                            </td>

                            <td class="col-2">
                                <button class="btn btn-sm btn-info mx-auto mb-1" data-toggle="modal" data-target="#donorDetail{{$data->id}}" style="width: 75px;">Detail</button>
                                <button class="btn btn-sm btn-info mx-auto mb-1" data-toggle="modal" data-target="#donorEvidence{{$data->id}}" style="width: 75px;">Bukti</button>

                                <div class="modal fade" id="donorDetail{{$data->id}}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                                    <div class="modal-dialog modal-lg" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header pb-1">
                                                <h5 class="modal-title" id="exampleModalLongTitle">Data Detail Pencari Plasma</h5>
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

                                <div class="modal fade" id="donorEvidence{{$data->id}}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLongTitle" aria-hidden="true">
                                    <div class="modal-dialog modal-lg" role="document">
                                        <div class="modal-content">
                                            <div class="modal-header pb-1">
                                                <h5 class="modal-title" id="exampleModalLongTitle">Bukti Donor</h5>
                                                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                    <span aria-hidden="true">&times;</span>
                                                </button>
                                            </div>
                                            <div class="modal-body py-0">
                                                <img src="{{url($data->donor_evidence_path)}}" class="border">
                                            </div>
                                            <div class="modal-footer">
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
    $(".history a").addClass("active");
</script>
@endsection