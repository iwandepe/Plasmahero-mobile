<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

class CreateDonorsTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('donors', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('user_id');

            $table->string('address')->nullable();
            $table->string('city')->nullable();
            $table->unsignedSmallInteger('age')->nullable();
            $table->string('phone')->nullable();
            $table->string('gender')->nullable();
            $table->string('blood_type')->nullable();
            $table->string('blood_rhesus')->nullable();
            $table->unsignedSmallInteger('weight')->nullable();

            $table->date('negative_test_date')->nullable(); // latest negative swab date
            $table->string('treatment')->nullable(); // [opname, isoman]
            $table->text('symptom')->nullable(); // gejala yang dialami jika perawatan isoman
            $table->unsignedTinyInteger('is_tranfusion')->nullable(); // 0 no, 1 yes, 2 do not know

            $table->boolean('is_vaccinated')->nullable();
            $table->string('vaccine_name')->nullable();
            $table->unsignedTinyInteger('vaccine_dose')->nullable();

            $table->boolean('is_donate_regularly')->nullable();
            $table->boolean('is_contact_shareable')->nullable();
            $table->boolean('is_voluntary')->nullable();

            $table->string('negative_evidence_path')->nullable();
            $table->string('positive_evidence_path')->nullable();

            $table->string('chronic_disease')->nullable();

            $table->unsignedSmallInteger('status'); // 0 new data, 1 not valid, 2 valid, 4 done

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
        Schema::dropIfExists('donors');
    }
}
