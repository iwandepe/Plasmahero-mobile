<?php

namespace App\Http\Controllers;

use App\Http\Library\ApiHelpers;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Symfony\Component\HttpFoundation\JsonResponse;

class DonorController extends Controller
{
    use ApiHelpers;

    public function getAllDonors(Request $request): JsonResponse
    {

        if ($this->isAdmin($request->user())) {
            $post = DB::table('donors')->get();

            return $this->onSuccess($post, 'Donor Retrieved');
        }

        return $this->onError(401, 'Unauthorized Access');
    }
}
