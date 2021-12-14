<?php


namespace App\Http\Controllers\API;

use Illuminate\Http\Request;
use App\Http\Controllers\Controller as Controller;


class BaseController extends Controller
{

  public function handleResponse($result, $msg = null)
  {
    $res = [
      'success' => true,
      'data'    => $result,
    ];
    if (!empty($msg)) {
      $res['message'] = $msg;
    }
    return response()->json($res, 200);
  }

  public function handleError($error, $errorMsg = [])
  {
    $res = [
      'success' => false,
      'message' => $error,
    ];
    return response()->json($res);
  }
}
