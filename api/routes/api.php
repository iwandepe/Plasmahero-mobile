<?php

use App\Http\Controllers\API\AuthController;
use App\Http\Controllers\API\DonorController;
use Illuminate\Support\Facades\Route;

Route::post('login', [AuthController::class, 'login']);
Route::post('register', [AuthController::class, 'register']);

Route::middleware('auth:sanctum')->group(function () {
  // Route::resource('donors', DonorController::class);
  Route::get('donors', [DonorController::class, 'getAllDonors']);
});
