<?php

namespace App\Http\Controllers\API;

use App\Models\Recipient;
use App\Models\User;
use Exception;
use Illuminate\Http\Request;
use Intervention\Image\Facades\Image;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Storage;
use Illuminate\Support\Facades\Validator;

class ContentController extends BaseController
{
    public function getAllFaqs()
    {
        $faqs = DB::table('faqs')->get();

        return $this->handleResponse($faqs);
    }

    public function getAllEvents()
    {
        $events = DB::table('events')->get();

        return $this->handleResponse($events);
    }

    public function getAllUdds()
    {
        $udds = DB::table('udds')->get();

        return $this->handleResponse($udds);
    }
}
