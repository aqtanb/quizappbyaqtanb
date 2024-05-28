package com.aktanberdi.littlequiz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Im
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat

class QuizQuestions : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var ifButtonPressed = false
    private var mSelectedOption: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mQuestionsList: ArrayList<Question>? = null
    private var mUserName: String? = null


    private var tvQuestion: TextView? = null
    private var ivImage: ImageView? = null
    private var progressBar: ProgressBar? = null
    private var tvProgress: TextView? = null
    private var firstOpt: TextView? = null
    private var secondOpt: TextView? = null
    private var thirdOpt: TextView? = null
    private var fourthOpt: TextView? = null
    private var btnSubmit: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)


        tvQuestion = findViewById(R.id.tvQuestion)
        ivImage = findViewById(R.id.ivImage)
        progressBar = findViewById(R.id.progressBar)
        tvProgress = findViewById(R.id.tvProgress)
        firstOpt = findViewById(R.id.firstOpt)
        secondOpt = findViewById(R.id.secondOpt)
        thirdOpt = findViewById(R.id.thirdOpt)
        fourthOpt = findViewById(R.id.fourthOpt)
        btnSubmit = findViewById(R.id.btnSubmit)

        mUserName = intent.getStringExtra(Constants.USER_NAME)
        mQuestionsList = Constants.getQuestions()

        firstOpt?.setOnClickListener(this)
        secondOpt?.setOnClickListener(this)
        thirdOpt?.setOnClickListener(this)
        fourthOpt?.setOnClickListener(this)
        btnSubmit?.setOnClickListener(this)


        setQuestion()
    }

    private fun setQuestion() {
        defaultOptionsView()


        val question: Question = mQuestionsList!![mCurrentPosition - 1]
        tvQuestion?.text = question.question
        ivImage?.setImageResource(question.ivImage)
        progressBar?.progress = mCurrentPosition
        tvProgress?.text = "$mCurrentPosition / ${progressBar?.max}"
        firstOpt?.text = question.firstOpt
        secondOpt?.text = question.secondOpt
        thirdOpt?.text = question.thirdOpt
        fourthOpt?.text = question.fourthOpt

        if (mCurrentPosition == mQuestionsList!!.size) {
            btnSubmit?.text = "Закончить"
        } else {
            btnSubmit?.text = "Дальше"
        }


    }

    private fun defaultOptionsView() {
        val options = ArrayList<TextView>()

        firstOpt?.let { options.add(0, it) }
        secondOpt?.let { options.add(1, it) }
        thirdOpt?.let { options.add(2, it) }
        fourthOpt?.let { options.add(3, it) }

        for (option in options) {
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this, R.drawable.default_border)
        }
    }

    private fun selectedOptionsView(tv: TextView, selectedOptionNum: Int) {
        defaultOptionsView()

        mSelectedOption = selectedOptionNum

        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_border)
        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            R.id.firstOpt -> {
                firstOpt?.let {
                    if (!ifButtonPressed) {
                        selectedOptionsView(it, 1)
                    }
                }
            }

            R.id.secondOpt -> {
                secondOpt?.let {
                    if (!ifButtonPressed) {
                        selectedOptionsView(it, 2)
                    }
                }
            }

            R.id.thirdOpt -> {
                thirdOpt?.let {
                    if (!ifButtonPressed) {
                        selectedOptionsView(it, 3)
                    }
                }
            }

            R.id.fourthOpt -> {
                fourthOpt?.let {
                    if (!ifButtonPressed) {
                        selectedOptionsView(it, 4)
                    }
                }
            }

            R.id.btnSubmit -> {
                if (mSelectedOption != 0) {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)
                    if (question!!.correctAnswer != mSelectedOption) {
                        answerView(mSelectedOption, R.drawable.wrond_border)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_border)



                    if (mSelectedOption == mQuestionsList!!.size) {
                        btnSubmit!!.text = "Закончить"
                    } else {
                        btnSubmit!!.text = "Следующий вопрос"
                    }
                    ifButtonPressed = true
                    mSelectedOption = 0
                    mCurrentPosition++

                } else {
                    ifButtonPressed = false
                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList?.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                firstOpt?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            2 -> {
                secondOpt?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            3 -> {
                thirdOpt?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
            4 -> {
                fourthOpt?.background = ContextCompat.getDrawable(
                    this, drawableView
                )
            }
        }
    }
}