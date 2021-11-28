<?php

namespace App\Http\Controllers\API;

use App\Models\Recipient;
use Exception;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;

class RecipientController extends BaseController
{
    public function getAllRecipients()
    {
        $recipients = DB::table('recipients')->get();

        return $this->handleResponse($recipients);
    }

    public function storeRecipient(Request $request)
    {
        try {
            $recipient = Recipient::create([
                'user_id' => $request->user_id,
                'hospital_name' => $request->address,
                'hospital_city' => $request->city,
                'phone' => $request->age,
                'blood_type' => $request->blood_type,
                'blood_rhesus' => $request->blood_rhesus
            ]);

            return $this->handleResponse($recipient);
        } catch (Exception $e) {
            return $e->getMessage();
        }
    }
}
