<?php

namespace App\Http\Controllers\Web;

use App\Http\Controllers\Controller;
use Illuminate\Support\Facades\DB;

class RecipientController extends Controller
{
	public function getRecipientPage()
	{
		$recipients = DB::table('recipients')
			->join('users', 'users.id', '=', 'recipients.user_id')
			->get();

		return view('admin.recipient', compact(['recipients']));
	}
}
