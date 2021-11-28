<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Schema;

class CreateDonorHistoriesTable extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('donor_histories', function (Blueprint $table) {
            $table->id();
            $table->unsignedBigInteger('donor_id');

            $table->string('udd')->nullable();
            $table->string('donor_date')->default(DB::raw('CURRENT_TIMESTAMP'))->nullable();
            $table->string('donor_evidence_path')->nullable();
            $table->boolean('is_valid')->default(false)->nullable();

            $table->foreign('donor_id')->references('id')->on('donors');
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
        Schema::dropIfExists('donor_histories');
    }
}
