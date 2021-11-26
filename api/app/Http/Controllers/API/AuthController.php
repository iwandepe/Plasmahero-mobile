<?php

namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Models\User;
use Illuminate\Support\Facades\Validator;

class AuthController extends BaseController
{

  public function login(Request $request)
  {
    if (Auth::attempt(['email' => $request->email, 'password' => $request->password])) {
      $user = Auth::user();
      if ($user !== null && $user instanceof User) {
        $data['token'] =  $user->createToken('auth_token')->plainTextToken;
        $data['name'] =  $user->name;
      }

      return $this->handleResponse($data, 'User logged in!');
    } else {
      return $this->handleError('Invalid login details', null, 401);
    }
  }

  public function register(Request $request)
  {
    $validator = Validator::make($request->all(), [
      'name' => 'required',
      'email' => 'required|email',
      'password' => 'required',
      'confirm_password' => 'required|same:password',
    ]);

    if ($validator->fails()) {
      return $this->handleError($validator->errors());
    }

    $input = $request->all();
    $input['password'] = bcrypt($input['password']);
    $user = User::create($input);
    $data['token'] =  $user->createToken('auth_token')->plainTextToken;
    $data['name'] =  $user->name;

    return $this->handleResponse($data, 'User successfully registered!');
  }
}
