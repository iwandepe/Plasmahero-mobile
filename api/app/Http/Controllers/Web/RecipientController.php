<?php

namespace App\Http\Controllers\Web;

use App\Http\Controllers\Controller;
use App\Models\Recipient;
use App\Models\User;
use Carbon\Carbon;
use Exception;
use Intervention\Image\Facades\Image;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Storage;

class RecipientController extends Controller
{
	public function getRecipientPage()
	{
		$recipients = DB::table('recipients')
			->join('users', 'users.id', '=', 'recipients.user_id')
			->get();

		return view('admin.recipient', compact(['recipients']));
	}

	public function verifyRecipient($userId)
	{
		try {
			// Handle generate poster
			$user = User::where('id', $userId)->first();
			$recipient = Recipient::where('user_id', $userId)->first();

			$posterData = [
				'name' => $user->name,
				'hospital_name' => $recipient->hospital_name,
				'blood_type' => $recipient->blood_type . ' ' . $recipient->blood_rhesus,
				'phone' => $recipient->phone
			];

			$posterPath = '/storage/' . $this->generatePoster($posterData);

			Recipient::where('id', $recipient->id)->update(array('generated_poster_path' => $posterPath,  'is_valid' => 1));

			return back()->with('success', 'Berhasil memvalidasi data pencari donor');
		} catch (Exception $e) {
			return $e->getMessage();
		}
	}

	public function generatePoster($data)
	{
		// $templatePath = 'img/poster-template.png';
		$templatePath = 'img/revisiPoster.png';

		$img = Image::make(public_path($templatePath));

		$img->text(strtoupper($data['name']), 1080, 725, function ($font) {
			$font->file(public_path('fonts/Basecoat/Basecoat-Regular.otf'));
			$font->color('#aa6100');
			$font->size(100);
			$font->align('center');
			$font->valign('bottom');
		});

		$img->text('GolDar ' . $data['blood_type'], 1080, 790, function ($font) {
			$font->file(public_path('fonts/Basecoat/Basecoat-Bold.ttf'));
			$font->size(145);
			$font->color('#fefefe');
			$font->align('center');
			$font->valign('top');
		});

		$img->text(strtoupper($data['hospital_name']), 1080, 1080, function ($font) {
			$font->file(public_path('fonts/Basecoat/Basecoat-Bold.ttf'));
			$font->size(100);
			$font->color('#44000a');
			$font->align('center');
			$font->valign('bottom');
		});

		$img->text('HUBUNGI: ' . $data['phone'], 1080, 1100, function ($font) {
			$font->file(public_path('fonts/Basecoat/Basecoat-Light.ttf'));
			$font->size(80);
			$font->color('#aa6100');
			$font->align('center');
			$font->valign('top');
		});

		$img->text('Dibuat pada ' . Carbon::now()->toDateString(), 1080, 1320, function ($font) {
			$font->file(public_path('fonts/Basecoat/Basecoat-Light.ttf'));
			$font->size(55);
			$font->color('#44000a');
			$font->align('center');
			$font->valign('bottom');
		});

		$img->stream();

		$imgPath = 'poster/' . time() . '.png';

		Storage::disk('local')->put('public/' . $imgPath, $img, 'public');

		return $imgPath;
	}
}
