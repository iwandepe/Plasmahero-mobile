<?php

namespace App\Http\Controllers\Web;

use App\Http\Controllers\Controller;
use App\Models\Donor;
use Exception;
use Illuminate\Support\Facades\DB;

class DonorController extends Controller
{
    public function getDonorPage()
    {
        $donors = DB::table('donors')
            ->join('users', 'users.id', '=', 'donors.user_id')
            ->get();

        return view('admin.donor', compact(['donors']));
    }

    public function getDonorHistoryPage()
    {
        $histories = DB::table('donor_histories')
            ->join('users', 'users.id', '=', 'donor_histories.user_id')
            ->join('donors', 'donors.user_id', '=', 'donor_histories.user_id')
            ->get();

        return view('admin.donor-history', compact(['histories']));
    }

    public function verifyDonor($userId)
    {
        try {
            $donor = Donor::where('user_id', $userId)->first();

            Donor::where('id', $donor->id)->update(array('is_valid' => 1));

            return back()->with('success', 'Berhasil memvalidasi data pendonor');
        } catch (Exception $e) {
            return $e->getMessage();
        }
    }
}
