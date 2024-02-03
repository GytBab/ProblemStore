package com.Babaitis.Project.ProblemStore.effect.service;


import com.Babaitis.Project.ProblemStore.effect.Effect;
import com.Babaitis.Project.ProblemStore.effect.dao.EffectDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EffectService {
        private EffectDao effectDao;

        @Autowired
        public EffectService(EffectDao effectDao) {
            this.effectDao = effectDao;
        }

        public List<Effect> getAllEffects() {
            return effectDao.getAll();
        }
}
