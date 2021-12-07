<table class="table-sm table-bordered" style="width: 100%;">
    <colgroup>
        <col span="1" style="width: 30%;">
        <col span="1" style="width: 70%;">
    </colgroup>
    <tbody>
        <tr>
            <td>Nama Lengkap</td>
            <td>{{$data->name}}</td>
        </tr>
        <tr>
            <td>Alamat</td>
            <td>{{$data->address}}</td>
        </tr>
        <tr>
            <td>Kota</td>
            <td>{{$data->city}}</td>
        </tr>
        <tr>
            <td>Usia</td>
            <td>{{$data->age}}</td>
        </tr>
        <tr>
            <td>No Whatsapp</td>
            <td>{{$data->phone}} <a href="https://wa.me/{{$data->phone}}" target="_blank" class="btn-sm btn-success mx-2">Hubungi <i class="fa fa-whatsapp"></i></a></td>
        </tr>
        <tr>
            <td>Jenis Kelamin</td>
            <td>{{$data->gender}}</td>
        </tr>
        <tr>
            <td>Golongan darah</td>
            <td>{{$data->blood_type}} {{$data->blood_rhesus}}</td>
        </tr>
        <tr>
            <td>Berat badan</td>
            <td>{{$data->weight}}</td>
        </tr>
        <tr>
            <td>Tanggal swab</td>
            <td>{{$data->negative_test_date}}</td>
        </tr>
        <tr>
            <td>Perawatan saat postif</td>
            <td>{{$data->treatment}}</td>
        </tr>

        <tr>
            <td>Gejala saat isoman</td>
            <td>{{$data->symptom}}</td>
        </tr>

        <tr>
            <td>Transfusi saat isoman</td>
            @if($data->is_tranfusion == 0)
            <td>Tidak mendapat transfusi</td>
            @elseif($data->is_tranfusion == 1)
            <td>Mendapat Transfusi</td>
            @else
            <td>Tidak tau</td>
            @endif
        </tr>

        <tr>
            <td>Sudah melakukan vaksinasi</td>
            @if($data->is_vaccinated)
            <td>Sudah Vaksinasi</td>
            @else
            <td>Belum vaksinasi</td>
            @endif
        </tr>

        <tr>
            <td>Nama vaksin</td>
            <td>{{$data->vaccine_name}}</td>
        </tr>

        <tr>
            <td>Dosis vaksinasi</td>
            <td>{{$data->vaccine_dose}}</td>
        </tr>

        <tr>
            <td>Donor darah rutin</td>
            @if($data->is_donate_regularly)
            <td>Bersedia</td>
            @else
            <td>Tidak bersedia</td>
            @endif
        </tr>

        <tr>
            <td>Consent Kontak</td>
            @if($data->is_contact_shareable)
            <td>Kontak boleh dibagikan ke pencari plasma</td>
            @else
            <td>Kontak tidak boleh dibagikan</td>
            @endif
        </tr>

        <tr>
            <td>Donor sukarela</td>
            @if($data->is_voluntary)
            <td>Bersedia</td>
            @else
            <td>Tidak bersedia</td>
            @endif
        </tr>

        <tr>
            <td>Penyakit Kronis</td>
            <td>{{$data->chronic_disease}}</td>
        </tr>

        <tr>
            <td>Bukti positif</td>
            <td>
                <img src="{{url($data->positive_evidence_path)}}" class="img-fluid border">
            </td>
        </tr>

        <tr>
            <td>Bukti negatif</td>
            <td>
                <img src="{{url($data->negative_evidence_path)}}" class="img-fluid border">
            </td>
        </tr>
    </tbody>
</table>