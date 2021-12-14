<?php

namespace App\Http\Controllers\API;

use App\Models\Recipient;
use App\Models\User;
use Carbon\Carbon;
use Exception;
use Illuminate\Http\Request;
use Intervention\Image\Facades\Image;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\Validator;

class RecipientController extends BaseController
{
    public function getAllRecipients()
    {
        $recipients = DB::table('recipients')->get();

        return $this->handleResponse($recipients);
    }

    public function getPosterUrl($id)
    {
        $recipient = Recipient::where('id', $id)->first();

        $baseUrl = env("APP_URL", "localhost:8000");
        $result['poster_url'] = $baseUrl . $recipient['generated_poster_path'];

        return $this->handleResponse($result);
    }

    public function storeRecipient(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'hospital_letter' => 'required',
        ]);

        if ($validator->fails()) {
            return $this->handleError($validator->errors());
        }
        try {
            // Handle posted image with base64
            $image = Image::make(file_get_contents($request->hospital_letter));
            $image->stream();
            $path = '/donors/positive/' . time() . ".png";
            Storage::disk('local')->put('public/' . $path, $image, 'public');

            User::where('id', $request->user_id)->update(['type' => 'recipient']);

            $recipient = Recipient::create([
                'user_id' => $request->user_id,
                'hospital_name' => $request->hospital_name,
                'hospital_city' => $request->hospital_city,
                'phone' => $request->phone,
                'blood_type' => $request->blood_type,
                'blood_rhesus' => $request->blood_rhesus,
                'hospital_letter_path' => '/storage' . $path,
            ]);

            $baseUrl = env("APP_URL", "localhost:8000");
            $recipient['hospital_letter_path'] = $baseUrl . $recipient['hospital_letter_path'];

            return $this->handleResponse($recipient);
        } catch (Exception $e) {
            return $e->getMessage();
        }
    }
}
