<?php

use App\Http\Controllers\API\AuthController;
use App\Http\Controllers\API\DonorController;
use App\Http\Controllers\API\DonorHistoryController;
use App\Http\Controllers\API\RecipientController;
use App\Http\Controllers\API\UserController;
use Illuminate\Support\Facades\Route;

Route::post('login', [AuthController::class, 'login']);
Route::post('register', [AuthController::class, 'register']);

Route::middleware('auth:sanctum')->group(function () {
  Route::get('donors', [DonorController::class, 'getAllDonors']);
  Route::post('donors', [DonorController::class, 'storeDonor']);

  Route::get('recipients', [RecipientController::class, 'getAllRecipients']);
  Route::post('recipients', [RecipientController::class, 'storeRecipient']);

  Route::get('users', [UserController::class, 'getAllUsers']);
  Route::get('profile/{id}', [UserController::class, 'getProfileById']);

  Route::get('donors/histories', [DonorHistoryController::class, 'getAllDonorHistories']);
  Route::get('donors/{userId}/histories', [DonorHistoryController::class, 'getHistoriesByUserId']);
  Route::post('donors/evidence', [DonorHistoryController::class, 'storeDonorEvidence']);
});
