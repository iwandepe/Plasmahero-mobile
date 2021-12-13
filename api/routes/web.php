<?php

use App\Http\Controllers\Web\DonorController;
use App\Http\Controllers\Web\RecipientController;
use Illuminate\Support\Facades\Route;

Route::get('/', function () {
    return view('welcome');
});

Route::group(['prefix' => '/admin', 'middleware' => 'auth'], function () {
    Route::get('/', function () {
        return view('admin.dashboard');
    })->name('dashboard');

    Route::get('/donors', [DonorController::class, 'getDonorPage'])->name('donors');
    Route::get('/recipients', [RecipientController::class, 'getRecipientPage'])->name('recipients');
    Route::get('/donor-history', [DonorController::class, 'getDonorHistoryPage'])->name('donor-history');
    Route::get('/recipient/{userId}/verify', [RecipientController::class, 'verifyRecipient'])->name('recipient-verify');
});

require __DIR__ . '/auth.php';
require __DIR__ . '/api.php';
