<?php

namespace App\Http\Controllers\API;

use App\Models\Donor;
use App\Models\Recipient;
use App\Models\User;
use Illuminate\Support\Facades\DB;

class UserController extends BaseController
{
  public function getAllUsers()
  {
    $users = DB::table('users')->get();

    return $this->handleResponse($users);
  }

  public function getProfileById($id)
  {
    $profile = User::where('id', $id)->first();

    if (Donor::where('user_id', $id)->count() > 0) {
      $profile['donor'] = Donor::where('user_id', $id)->get();
    }

    if (Recipient::where('user_id', $id)->count() > 0) {
      $profile['recipient'] = Recipient::where('user_id', $id)->get();
    }

    return $this->handleResponse($profile);
  }
}
