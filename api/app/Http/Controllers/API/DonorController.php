<?php

namespace App\Http\Controllers\API;

use App\Http\Controllers\API\BaseController;
use Illuminate\Support\Facades\DB;

class DonorController extends BaseController
{
    public function getAllDonors()
    {
        $donors = DB::table('donors')->get();

        return $this->handleResponse($donors);
    }
}
