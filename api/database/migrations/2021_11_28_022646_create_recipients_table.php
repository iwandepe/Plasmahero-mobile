<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateRecipientsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('recipients', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('user_id');

            $table->string('hospital_name')->nullable();
            $table->string('hospital_city')->nullable();
            $table->string('phone')->nullable();
            $table->string('blood_type')->nullable();
            $table->string('blood_rhesus')->nullable();

            $table->string('hospital_letter_path')->nullable();

            $table->boolean('is_valid')->default(false)->nullable();

            $table->foreign('user_id')->references('id')->on('users');

            $table->timestamps();
        });
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('recipients');
    }
}
