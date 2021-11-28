<?php

namespace App\Http\Controllers\API;

use App\Http\Controllers\API\BaseController;
use App\Models\Donor;
use Exception;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class DonorController extends BaseController
{
    public function getAllDonors()
    {
        $donors = DB::table('donors')->get();

        return $this->handleResponse($donors);
    }

    public function storeDonor(Request $request)
    {
        try {
            $donor = Donor::create([
                'user_id' => $request->user_id,
                'address' => $request->address,
                'city' => $request->city,
                'age' => $request->age,
                'phone' => $request->phone,
                'gender' => $request->gender,
                'blood_type' => $request->blood_type,
                'blood_rhesus' => $request->blood_rhesus,
                'weight' => $request->weight,
                'negative_test_date' => $request->negative_test_date,
                'treatment' => $request->treatment,
                'symptom' => $request->symptom,
                'is_tranfusion' => $request->is_tranfusion,
                'donor_rutin' => $request->donor_rutin,
                'is_contact_shareable' => $request->is_contact_shareable,
                'is_voluntary' => $request->is_voluntary,
                'is_donate_regularly' => $request->is_donate_regularly,
                'is_vaccinated' => $request->is_vaccinated,
                'vaccine_name' => $request->vaccine_name,
                'vaccine_dose' => $request->vaccine_dose,
                'chronic_disease' => $request->chronic_disease,
                'status' => 0
            ]);

            return $this->handleResponse($donor);
        } catch (Exception $e) {
            return $e->getMessage();
        }
    }
}
