    package com.telusko.service;

    import com.telusko.entity.Quiz;
    import com.telusko.feign.QuizInterface;
    import com.telusko.payload.Answers;
    import com.telusko.payload.QuestionsDto;
    import com.telusko.repository.QuizRepository;
    import org.springframework.stereotype.Service;

    import java.util.ArrayList;
    import java.util.Collections;
    import java.util.List;
    import java.util.Optional;

    @Service
    public class QuizServiceImpl implements QuizService {


        private QuizRepository quizRepository;
        private QuizInterface quizInterface;
        public QuizServiceImpl(QuizRepository quizRepository, QuizInterface quizInterface) {
            this.quizRepository = quizRepository;
            this.quizInterface = quizInterface;
        }

        @Override
        public Quiz createQuiz(String category, Long numQ, String title) {

            List<Long> questionIDs = quizInterface.getQuestionForQuiz(category,numQ).getBody();
            Quiz quiz = new Quiz();
            quiz.setTitle(title);
            quiz.setQuestionIDs(questionIDs);
            Quiz save = quizRepository.save(quiz);
            return save;
        }

        @Override
        public List<QuestionsDto> getQuizQuestions(Long id) {

            Quiz quiz = quizRepository.findById(id).get();
            List<Long> questionIDs = quiz.getQuestionIDs();

            List<QuestionsDto> questionsDto = quizInterface.getQuestions(questionIDs).getBody();

            return questionsDto;
        }

        @Override
        public Integer calculateRessult(Long id, List<Answers> answers) {
            Integer score = quizInterface.getScore(answers).getBody();
            return score;
        }



    }
