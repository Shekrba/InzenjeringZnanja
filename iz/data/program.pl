poklapanje_simptoma([],Bolest,0,[]).
poklapanje_simptoma([H|T],Bolest,N,L) :- simptomi(Bolest,Ls),member(H,Ls) , poklapanje_simptoma(T,Bolest,N2,L1), N is N2 + 1, append([H],L1,L).
poklapanje_simptoma([H|T],Bolest,N,L) :- simptomi(Bolest,Ls),\+ member(H,Ls), poklapanje_simptoma(T,Bolest,N,L).

simptomi(acute_respiratory_distress_syndrome,[shortness_of_breath,	difficulty_breathing, cough, sharp_chest_pain,depressive_or_psychotic_symptoms, fever, wheezing,hurts_to_breath,chest_tightness,chills,coughing_up_sputum, congestion_in_chest]).

uzmi(bolest,acute_respiratory_distress_syndrome).
uzmi(bolest,hypertensive_heart_disease).
uzmi(bolest,ischemic_heart_disease).
uzmi(bolest,diabetes).
uzmi(bolest,anemia).
uzmi(bolest,coagulation_bleeding_disorder).
uzmi(bolest,viral_hepatitis).
uzmi(bolest,gastroesophageal_reflux_disease_gerd).
uzmi(bolest,chronic_constipation).
uzmi(bolest,emphysema).
uzmi(bolest,urinary_tract_infection).
uzmi(bolest,dementia).
uzmi(bolest,hyperlipidemia).
uzmi(bolest,cardiomyopathy).
uzmi(bolest,bronchiectasis).
uzmi(bolest,celiac_disease).
uzmi(bolest,gastritis).
uzmi(bolest,cirrhosis).
uzmi(bolest,hyponatremia).
uzmi(bolest,cerebral_palsy).
uzmi(bolest,polymyalgia_rheumatica).
uzmi(bolest,myocarditis).
uzmi(bolest,meningitis).
uzmi(bolest,multiple_sclerosis).
uzmi(bolest,parkinson_disease).
uzmi(bolest,encephalitis).
uzmi(bolest,bell_palsy).


prevalence(acute_respiratory_distress_syndrome,0.07).

acute_respiratory_distress_syndrome(shortness_of_breath,84).
acute_respiratory_distress_syndrome(difficulty_breathing,72).
acute_respiratory_distress_syndrome(cough,45).
acute_respiratory_distress_syndrome(sharp_chest_pain,39).
acute_respiratory_distress_syndrome(depressive_or_psychotic_symptoms,35).
acute_respiratory_distress_syndrome(fever,32).
acute_respiratory_distress_syndrome(wheezing,20).
acute_respiratory_distress_syndrome(hurts_to_breath,11).
acute_respiratory_distress_syndrome(chest_tightness,11).
acute_respiratory_distress_syndrome(chills,9).
acute_respiratory_distress_syndrome(coughing_up_sputum,9).
acute_respiratory_distress_syndrome(congestion_in_chest,9).


simptomi(hypertensive_heart_disease,[palpitations,shortness_of_breath,sharp_chest_pain,difficulty_breathing,weakness,fatigue,chest_tightness, insomnia,heartburn,leg_swelling,fluid_retention,recent_pregnancy]).

prevalence(hypertensive_heart_disease, 21).

hypertensive_heart_disease(palpitations,48).
hypertensive_heart_disease(shortness_of_breath,45).
hypertensive_heart_disease(sharp_chest_pain,44).
hypertensive_heart_disease(difficulty_breathing,42).
hypertensive_heart_disease(weakness,28).
hypertensive_heart_disease(fatigue,26).
hypertensive_heart_disease(chest_tightness,23).
hypertensive_heart_disease(insomnia,15).
hypertensive_heart_disease(heartburn,11).
hypertensive_heart_disease(leg_swelling,8).
hypertensive_heart_disease(fluid_retention,8).
hypertensive_heart_disease(recent_pregnancy,4).


simptomi(ischemic_heart_disease,[sharp_chest_pain,shortness_of_breath,difficulty_breathing,palpitations, dizziness,fatigue, chest_tightness,peripheral_edema,lymphedemia,increased_heart_rate,muscle_pain, throat_feels_tight]).

prevalence(ischemic_heart_disease,5.3).

ischemic_heart_disease(sharp_chest_pain,57).
ischemic_heart_disease(shortness_of_breath,48).
ischemic_heart_disease(difficulty_breathing,32).
ischemic_heart_disease(palpitations,31).
ischemic_heart_disease(dizziness,28).
ischemic_heart_disease(fatigue,27).
ischemic_heart_disease(chest_tightness,26).
ischemic_heart_disease(peripheral_edema,13).
ischemic_heart_disease(lymphedemia,8).
ischemic_heart_disease(increased_heart_rate,5).
ischemic_heart_disease(muscle_pain,5).
ischemic_heart_disease(throat_feels_tight,3).


simptomi(diabetes,[weight_gain,thirst,symptoms_of_the_kidneys]).

prevalence(diabetes, 6).

diabetes(weight_gain,7).
diabetes(thirst,2).
diabetes(symptoms_of_the_kidneys,1).


simptomi(anemia, [fatigue,weakness,dizziness,shortness_of_breath,nosebleed,heavy_menstrual_flow, melena,unpredictable_menstruation,vomiting_blood,changes_in_stool_appearance,recent_pregnancy,too_little_hair]).

prevalence(anemia, 10).

anemia(fatigue,32).
anemia(weakness,28).
anemia(dizziness,27).
anemia(shortness_of_breath,26).
anemia(nosebleed,8).
anemia(heavy_menstrual_flow,8).
anemia(melena,4).
anemia(unpredictable_menstruation,3).
anemia(vomiting_blood,3).
anemia(changes_in_stool_appearance,2).
anemia(recent_pregnancy,2).
anemia(too_little_hair,2).


simptomi(coagulation_bleeding_disorder,[leg_pain,leg_swelling,nosebleed,blood_in_urine,eye_redness,melena,lymphedema,hemoptysis,leg_cramps_or_spasms,early_or_late_onset_of_menopause,knee_swelling,vaginal_pain]).

prevalence(coagulation_bleeding_disorder,0.1).

coagulation_bleeding_disorder(leg_pain,30).
coagulation_bleeding_disorder(leg_swelling,17).
coagulation_bleeding_disorder(nosebleed,17).
coagulation_bleeding_disorder(blood_in_urine,17).
coagulation_bleeding_disorder(eye_redness,11).
coagulation_bleeding_disorder(melena,8).
coagulation_bleeding_disorder(lymphedema,8).
coagulation_bleeding_disorder(hemoptysis,8).
coagulation_bleeding_disorder(leg_cramps_or_spasms,4).
coagulation_bleeding_disorder(early_or_late_onset_of_menopause,4).
coagulation_bleeding_disorder(knee_swelling,4).
coagulation_bleeding_disorder(vaginal_pain,4).


simptomi(viral_hepatitis,[sharp_abdominal_pain,abusing_alcohol,drug_abuse,melena,stomach_bloating,symptoms_of_the_kidneys,hand_or_finger_stiffness_or_tightness,low_self_esteem,incontinence_of_stool]).

prevalence(viral_hepatitis,4.8).

viral_hepatitis(sharp_abdominal_pain,26).
viral_hepatitis(abusing_alcohol,13).
viral_hepatitis(drug_abuse,13).
viral_hepatitis(melena,3).
viral_hepatitis(stomach_bloating,2).
viral_hepatitis(symptoms_of_the_kidneys,1).
viral_hepatitis(hand_or_finger_stiffness_or_tightness,1).
viral_hepatitis(low_self_esteem,1).
viral_hepatitis(incontinence_of_stool,1).


simptomi(gastroesophageal_reflux_disease_gerd,[sharp_chest_pain,sharp_abdominal_pain,vomiting,heartburn,cough,nausea,burning_abdominal_pain,upper_abdominal_pain,difficulty_in_swallowing,regurgitation,chest_tightness,hoarse_voice]).

prevalence(gastroesophageal_reflux_disease_gerd,20.0).

gastroesophageal_reflux_disease_gerd(sharp_chest_pain,44).
gastroesophageal_reflux_disease_gerd(sharp_abdominal_pain,43).
gastroesophageal_reflux_disease_gerd(vomiting,33).
gastroesophageal_reflux_disease_gerd(heartburn,33).
gastroesophageal_reflux_disease_gerd(cough,33).
gastroesophageal_reflux_disease_gerd(nausea,28).
gastroesophageal_reflux_disease_gerd(burning_abdominal_pain,21).
gastroesophageal_reflux_disease_gerd(upper_abdominal_pain,16).
gastroesophageal_reflux_disease_gerd(difficulty_in_swallowing,16).
gastroesophageal_reflux_disease_gerd(regurgitation,13).
gastroesophageal_reflux_disease_gerd(chest_tightness,11).
gastroesophageal_reflux_disease_gerd(hoarse_voice,10).


simptomi(chronic_constipation,[constipation,sharp_abdominal_pain,burning_abdominal_pain,vomiting,nausea,lower_abdominal_pain,rectal_bleeding,blood_in_stool,pain_of_the_anus,retention_of_urine,stomach_bloating,changes_in_stool_appearance]).

prevalence(chronic_constipation,15.0).

chronic_constipation(constipation,87).
chronic_constipation(sharp_abdominal_pain,77).
chronic_constipation(burning_abdominal_pain,37).
chronic_constipation(vomiting,34).
chronic_constipation(nausea,29).
chronic_constipation(lower_abdominal_pain,19).
chronic_constipation(rectal_bleeding,18).
chronic_constipation(blood_in_stool,17).
chronic_constipation(pain_of_the_anus,13).
chronic_constipation(retention_of_urine,11).
chronic_constipation(stomach_bloating,11).
chronic_constipation(changes_in_stool_appearance,10).


simptomi(emphysema,[sharp_chest_pain,shortness_of_breath,chest_tightness,cough,nausea,ache_all_over,back_pain,cross_eyed,itchy_eyelid,excessive_growth,emotional_symptoms,elbow_cramps_or_spasms]).

prevalence(emphysema,1.8).

emphysema(sharp_chest_pain,89).
emphysema(shortness_of_breath,69).
emphysema(chest_tightness,69).
emphysema(cough,51).
emphysema(nausea,51).
emphysema(ache_all_over,51).
emphysema(back_pain,51).
emphysema(cross_eyed,4).
emphysema(itchy_eyelid,4).
emphysema(excessive_growth,4).
emphysema(emotional_symptoms,4).
emphysema(elbow_cramps_or_spasms,4).


simptomi(urinary_tract_infection,[painful_urination,suprapubic_pain,sharp_abdominal_pain,frequent_urination,fever,vomiting,back_pain,nausea,blood_in_urine,side_pain,retention_of_urine,lower_abdominal_pain]).

prevalence(urinary_tract_infection,21.5).

urinary_tract_infection(painful_urination,65).
urinary_tract_infection(suprapubic_pain,60).
urinary_tract_infection(sharp_abdominal_pain,60).
urinary_tract_infection(frequent_urination,46).
urinary_tract_infection(fever,42).
urinary_tract_infection(vomiting,40).
urinary_tract_infection(back_pain,36).
urinary_tract_infection(nausea,35).
urinary_tract_infection(blood_in_urine,33).
urinary_tract_infection(side_pain,31).
urinary_tract_infection(retention_of_urine,26).
urinary_tract_infection(lower_abdominal_pain,25).


simptomi(dementia,[disturbance_of_memory,problems_with_movement,dizziness,depressive_or_psychotic_symptoms,abnormal_involuntary_movements,paresthesia,hostile_behavior,delusions_or_hallucinations,difficulty_speaking,insomnia,disturbance_of_smell_or_taste,focal_weakness]).

prevalence(dementia,0.7).

dementia(disturbance_of_memory,53).
dementia(problems_with_movement,45).
dementia(dizziness,32).
dementia(depressive_or_psychotic_symptoms,32).
dementia(abnormal_involuntary_movements,26).
dementia(paresthesia,21).
dementia(hostile_behavior,21).
dementia(delusions_or_hallucinations,15).
dementia(difficulty_speaking,13).
dementia(insomnia,13).
dementia(disturbance_of_smell_or_taste,13).
dementia(focal_weakness,9).


simptomi(hyperlipidemia,[sharp_chest_pain,weight_gain,lymphedema,smoking_problems,leg_cramps_or_spasms]).

prevalence(hyperlipidemia,0.2).

hyperlipidemia(sharp_chest_pain,25).
hyperlipidemia(weight_gain,10).
hyperlipidemia(lymphedema,2).
hyperlipidemia(smoking_problems,2).
hyperlipidemia(leg_cramps_or_spasms,2).


simptomi(cardiomyopathy,[shortness_of_breath,sharp_chest_pain,fatigue,peripheral_edema,palpitations,chest_tightness,weight_gain,irregular_heartbeat,heartburn,excessive_urination_at_night,decreased_heart_rate,muscle_weakness]).

prevalence(cardiomyopathy,0.2).

cardiomyopathy(shortness_of_breath,53).
cardiomyopathy(sharp_chest_pain,39).
cardiomyopathy(fatigue,27).
cardiomyopathy(peripheral_edema,16).
cardiomyopathy(palpitations,13).
cardiomyopathy(chest_tightness,13).
cardiomyopathy(weight_gain,9).
cardiomyopathy(irregular_heartbeat,9).
cardiomyopathy(heartburn,6).
cardiomyopathy(excessive_urination_at_night,2).
cardiomyopathy(decreased_heart_rate,2).
cardiomyopathy(muscle_weakness,2).


simptomi(bronchiectasis,[cough,shortness_of_breath,hemoptysis,difficulty_breathing,coughing_up_sputum,nasal_congestion,coryza,sore_throat,fever,fatigue,drainage_in_throat,fluid_retention]).

prevalence(bronchiectasis,0.13).

bronchiectasis(cough,74).
bronchiectasis(shortness_of_breath,56).
bronchiectasis(hemoptysis,47).
bronchiectasis(difficulty_breathing,41).
bronchiectasis(coughing_up_sputum,41).
bronchiectasis(nasal_congestion,34).
bronchiectasis(coryza,34).
bronchiectasis(sore_throat,34).
bronchiectasis(fever,25).
bronchiectasis(fatigue,25).
bronchiectasis(drainage_in_throat,25).
bronchiectasis(fluid_retention,14).


simptomi(celiac_disease,[sharp_abdominal_pain,diarrhea,regurgitation,fatigue,vomiting,nausea,allergic_reaction,sharp_chest_pain,fears_and_phobias,peripheral_edema,leg_lump_or_mass,constipation]).

prevalence(celiac_disease,1.0).

celiac_disease(sharp_abdominal_pain,52).
celiac_disease(diarrhea,52).
celiac_disease(regurgitation,47).
celiac_disease(fatigue,41).
celiac_disease(vomiting,41).
celiac_disease(nausea,34).
celiac_disease(allergic_reaction,25).
celiac_disease(sharp_chest_pain,25).
celiac_disease(fears_and_phobias,15).
celiac_disease(peripheral_edema,15).
celiac_disease(leg_lump_or_mass,15).
celiac_disease(constipation,15).


simptomi(gastritis,[sharp_abdominal_pain,vomiting,nausea,burning_abdominal_pain,sharp_chest_pain,upper_abdominal_pain,diarrhea,fever,headache,heartburn,vomiting_blood,regurgitation]).

prevalence(gastritis,4.5).

gastritis(sharp_abdominal_pain,82).
gastritis(vomiting,75).
gastritis(nausea,65).
gastritis(burning_abdominal_pain,55).
gastritis(sharp_chest_pain,41).
gastritis(upper_abdominal_pain,40).
gastritis(diarrhea,40).
gastritis(fever,27).
gastritis(headache,24).
gastritis(heartburn,24).
gastritis(vomiting_blood,20).
gastritis(regurgitation,15).


simptomi(cirrhosis,[sharp_abdominal_pain,shortness_of_breath,peripheral_edema,fatigue,upper_abdominal_pain,abdominal_distention,stomach_bloating,blood_in_stool,regurgitation,symptoms_of_the_kidneys,vomiting_blood,melena]).

prevalence(cirrhosis,0.27).

cirrhosis(sharp_abdominal_pain,39).
cirrhosis(shortness_of_breath,30).
cirrhosis(peripheral_edema,24).
cirrhosis(fatigue,20).
cirrhosis(upper_abdominal_pain,20).
cirrhosis(abdominal_distention,16).
cirrhosis(stomach_bloating,10).
cirrhosis(blood_in_stool,10).
cirrhosis(regurgitation,8).
cirrhosis(symptoms_of_the_kidneys,5).
cirrhosis(vomiting_blood,5).
cirrhosis(melena,5).


simptomi(hyponatremia,[weakness,vomiting,nausea,shortness_of_breath,dizziness,sharp_abdominal_pain,sharp_chest_pain,headache,back_pain,fever,fainting,seizures]).

prevalence(hyponatremia,1.72).

hyponatremia(weakness,55).
hyponatremia(vomiting,53).
hyponatremia(nausea,48).
hyponatremia(shortness_of_breath,44).
hyponatremia(dizziness,44).
hyponatremia(sharp_abdominal_pain,38).
hyponatremia(sharp_chest_pain,33).
hyponatremia(headache,33).
hyponatremia(back_pain,28).
hyponatremia(fever,28).
hyponatremia(fainting,25).
hyponatremia(seizures,23).


simptomi(cerebral_palsy,[seizures,problems_with_movement,cramps_and_spasms,difficulty_eating,lack_of_growth,leg_cramps_or_spasms,back_cramps_or_spasms,blindness,infant_feeding_problem,swollen_tongue,lip_sore,tongue_lesions]).

prevalence(cerebral_palsy,0.2).

cerebral_palsy(seizures,51).
cerebral_palsy(problems_with_movement,29).
cerebral_palsy(cramps_and_spasms,14).
cerebral_palsy(difficulty_eating,6).
cerebral_palsy(lack_of_growth,6).
cerebral_palsy(leg_cramps_or_spasms,4).
cerebral_palsy(back_cramps_or_spasms,4).
cerebral_palsy(blindness,4).
cerebral_palsy(infant_feeding_problem,2).
cerebral_palsy(swollen_tongue,2).
cerebral_palsy(lip_sore,2).
cerebral_palsy(tongue_lesions,2).


simptomi(polymyalgia_rheumatica,[fatigue,shoulder_pain,leg_pain,ache_all_over,sharp_chest_pain,muscle_pain,hip_pain,irregular_heartbeat,leg_weakness,stiffness_all_over,difficulty_in_swallowing,temper_problems]).

prevalence(polymyalgia_rheumatica,0.32).

polymyalgia_rheumatica(fatigue,47).
polymyalgia_rheumatica(shoulder_pain,42).
polymyalgia_rheumatica(leg_pain,36).
polymyalgia_rheumatica(ache_all_over,36).
polymyalgia_rheumatica(sharp_chest_pain,30).
polymyalgia_rheumatica(muscle_pain,22).
polymyalgia_rheumatica(hip_pain,22).
polymyalgia_rheumatica(irregular_heartbeat,22).
polymyalgia_rheumatica(leg_weakness,12).
polymyalgia_rheumatica(stiffness_all_over,12).
polymyalgia_rheumatica(difficulty_in_swallowing,12).
polymyalgia_rheumatica(temper_problems,12).


simptomi(myocarditis,[palpitations,ache_all_over,cough,chest_tightness,fever,sharp_chest_pain,weakness,diarrhea,headache,difficulty_breathing,dizziness,coughing_up_sputum]).

prevalence(myocarditis,1.06).

myocarditis(palpitations,67).
myocarditis(ache_all_over,56).
myocarditis(cough,56).
myocarditis(chest_tightness,56).
myocarditis(fever,56).
myocarditis(sharp_chest_pain,56).
myocarditis(weakness,38).
myocarditis(diarrhea,38).
myocarditis(headache,38).
myocarditis(difficulty_breathing,38).
myocarditis(dizziness,38).
myocarditis(coughing_up_sputum,38).


simptomi(meningitis,[headache,fever,vomiting,neck_pain,ache_all_over,back_pain,seizures,nausea,low_back_pain,cough,leg_pain,neck_stiffness_or_tightness]).

prevalence(meningitis,1.2E-4).

meningitis(headache,87).
meningitis(fever,80).
meningitis(vomiting,53).
meningitis(neck_pain,48).
meningitis(ache_all_over,42).
meningitis(back_pain,31).
meningitis(seizures,31).
meningitis(nausea,31).
meningitis(low_back_pain,26).
meningitis(cough,26).
meningitis(leg_pain,26).
meningitis(neck_stiffness_or_tightness,21).


simptomi(multiple_sclerosis,[fatigue,loss_of_sensation,headache,dizziness,problems_with_movement,weakness,leg_weakness,paresthesia,disturbance_of_memory,abnormal_involuntary_movements,leg_stiffness_or_tightness,focal_weakness]).

prevalence(multiple_sclerosis,0.03).

multiple_sclerosis(fatigue,43).
multiple_sclerosis(loss_of_sensation,42).
multiple_sclerosis(headache,31).
multiple_sclerosis(dizziness,28).
multiple_sclerosis(problems_with_movement,27).
multiple_sclerosis(weakness,22).
multiple_sclerosis(leg_weakness,19).
multiple_sclerosis(paresthesia,16).
multiple_sclerosis(disturbance_of_memory,13).
multiple_sclerosis(abnormal_involuntary_movements,12).
multiple_sclerosis(leg_stiffness_or_tightness,12).
multiple_sclerosis(focal_weakness,11).


simptomi(parkinson_disease,[abnormal_involuntary_movements,problems_with_movement,disturbance_of_memory,dizziness,weakness,stiffness_all_over,leg_weakness,focal_weakness,muscle_stiffness_or_tightness,difficulty_speaking,leg_stiffness_or_tightness,fears_and_phobias]).

prevalence(parkinson_disease,0.12).

parkinson_disease(abnormal_involuntary_movements,64).
parkinson_disease(problems_with_movement,41).
parkinson_disease(disturbance_of_memory,28).
parkinson_disease(dizziness,25).
parkinson_disease(weakness,22).
parkinson_disease(stiffness_all_over,7).
parkinson_disease(leg_weakness,7).
parkinson_disease(focal_weakness,5).
parkinson_disease(muscle_stiffness_or_tightness,5).
parkinson_disease(difficulty_speaking,4).
parkinson_disease(leg_stiffness_or_tightness,3).
parkinson_disease(fears_and_phobias,3).


simptomi(encephalitis,[headache,loss_of_sensation,seizures,dizziness,leg_pain,fatigue,disturbance_of_memory,problems_with_movement,paresthesia,insomnia,joint_pain,leg_weakness]).

prevalence(encephalitis,0.005).

encephalitis(headache,62).
encephalitis(loss_of_sensation,53).
encephalitis(seizures,53).
encephalitis(dizziness,39).
encephalitis(leg_pain,39).
encephalitis(fatigue,30).
encephalitis(disturbance_of_memory,30).
encephalitis(problems_with_movement,18).
encephalitis(paresthesia,18).
encephalitis(joint_pain,18).
encephalitis(leg_weakness,18).


simptomi(bell_palsy,[focal_weakness,loss_of_sensation,symptoms_of_the_face,headache,facial_pain,weakness,peripheral_edema,symptoms_of_eye,paresthesia,diminished_vision,eyelid_lesion_or_rash,abnormal_involuntary_movements]).

prevalence(bell_palsy,0.1).

bell_palsy(focal_weakness,82).
bell_palsy(loss_of_sensation,70).
bell_palsy(symptoms_of_the_face,67).
bell_palsy(headache,51).
bell_palsy(facial_pain,39).
bell_palsy(weakness,28).
bell_palsy(peripheral_edema,24).
bell_palsy(symptoms_of_eye,21).
bell_palsy(paresthesia,19).
bell_palsy(diminished_vision,19).
bell_palsy(eyelid_lesion_or_rash,16).
bell_palsy(abnormal_involuntary_movements,16).


sex_factor(acute_respiratory_distress_syndrome,male,1.1).
sex_factor(acute_respiratory_distress_syndrome,female,0.9).

ages_factor(acute_respiratory_distress_syndrome,0,1,0.9).
ages_factor(acute_respiratory_distress_syndrome,1,4,0.3).
ages_factor(acute_respiratory_distress_syndrome,5,14,0.2).
ages_factor(acute_respiratory_distress_syndrome,15,29,0.2).
ages_factor(acute_respiratory_distress_syndrome,30,44,0.4).
ages_factor(acute_respiratory_distress_syndrome,45,59,1.1).
ages_factor(acute_respiratory_distress_syndrome,60,74,2.0).
ages_factor(acute_respiratory_distress_syndrome,75,150,3.3).


testovi(acute_respiratory_distress_syndrome,radiographic_imaging_procedure).
testovi(acute_respiratory_distress_syndrome,hematologic_tests_blood_test).
testovi(acute_respiratory_distress_syndrome,complete_blood_count_cbc).
testovi(acute_respiratory_distress_syndrome,plain_x-ray_x_ray).
testovi(acute_respiratory_distress_syndrome,electrocardiogram).
testovi(acute_respiratory_distress_syndrome,intravenous_fluid_replacement).
testovi(acute_respiratory_distress_syndrome,kidney_function_tests_kidney_function_test).
testovi(acute_respiratory_distress_syndrome,electrolytes_panel).


terapija(acute_respiratory_distress_syndrome,methylprednisolone_medrol_21_days).
terapija(acute_respiratory_distress_syndrome,levofloxacin_levaquin_7_days).
terapija(acute_respiratory_distress_syndrome,midazolam_versed).
terapija(acute_respiratory_distress_syndrome,propofol).
terapija(acute_respiratory_distress_syndrome,ipratropium_21_days).
terapija(acute_respiratory_distress_syndrome,zosyn_7_days).
terapija(acute_respiratory_distress_syndrome,dopamine).
terapija(acute_respiratory_distress_syndrome,vancomycin_7_days).
terapija(acute_respiratory_distress_syndrome,combivent_28_days).
terapija(acute_respiratory_distress_syndrome,vecuronium).
terapija(acute_respiratory_distress_syndrome,oxygen).
terapija(acute_respiratory_distress_syndrome,moxifloxacin_avelox_14_days).
terapija(acute_respiratory_distress_syndrome,enoxaparin_lovenox_7_days).


sex_factor(anemia,male,0.7).
sex_factor(anemia,female,1.2).

ages_factor(anemia,0,1,0.4).
ages_factor(anemia,1,4,0.6).
ages_factor(anemia,5,14,0.2).
ages_factor(anemia,15,29,0.8).
ages_factor(anemia,30,44,0.8).
ages_factor(anemia,45,59,0.9).
ages_factor(anemia,60,74,1.5).
ages_factor(anemia,75,150,2.5).


testovi(anemia,hematologic_tests_blood_test).
testovi(anemia,complete_blood_count_cbc).
testovi(anemia,glucose_measurement_glucose_level).
testovi(anemia,electrolytes_panel).
testovi(anemia,urinalysis).
testovi(anemia,kidney_function_tests_kidney_function_test).
testovi(anemia,electrocardiogram).
testovi(anemia,intravenous_fluid_replacement).


terapija(anemia,epoetin_alfa_procrit_21_days).
terapija(anemia,darbepoetin_alfa_aranesp_21_days).
terapija(anemia,ferric_oxide,_saccharated_venofer).
terapija(anemia,filgrastim_neupogen_14_days).
terapija(anemia,sodium_ferric_gluconate_complex_ferrlecit).
terapija(anemia,deferasirox_exjade_28_days).
terapija(anemia,valganciclovir_valcyte_28_days).
terapija(anemia,ferrous_gluconate_28_days).
terapija(anemia,lenalidomide_revlimid_28_days).
terapija(anemia,sorafenib_28_days).
terapija(anemia,anagrelide_28_days).
terapija(anemia,dextran_1).


sex_factor(polymyalgia_rheumatica,male,0.7).
sex_factor(polymyalgia_rheumatica,female,1.3).

ages_factor(polymyalgia_rheumatica,0,1,0.0221).
ages_factor(polymyalgia_rheumatica,1,4,0.022).
ages_factor(polymyalgia_rheumatica,5,14,0.022).
ages_factor(polymyalgia_rheumatica,15,29,0.1).
ages_factor(polymyalgia_rheumatica,30,44,0.1).
ages_factor(polymyalgia_rheumatica,45,59,0.3).
ages_factor(polymyalgia_rheumatica,60,74,2.6).
ages_factor(polymyalgia_rheumatica,75,150,5.4).


testovi(polymyalgia_rheumatica,lipid_panel).
testovi(polymyalgia_rheumatica,mammography_mammogram).
testovi(polymyalgia_rheumatica,examination_of_breast).
testovi(polymyalgia_rheumatica,bone_density_scan).
testovi(polymyalgia_rheumatica,rectal_examination).
testovi(polymyalgia_rheumatica,physical_therapy_exercises_exercises).
testovi(polymyalgia_rheumatica,biopsy).
testovi(polymyalgia_rheumatica,procedures_on_spleen_spleen_operation).


terapija(polymyalgia_rheumatica,prednisone_28_days).
terapija(polymyalgia_rheumatica,atenolol_28_days).
terapija(polymyalgia_rheumatica,alendronate).
terapija(polymyalgia_rheumatica,calcium_carbonate_28_days).
terapija(polymyalgia_rheumatica,methotrexate_28_days).
terapija(polymyalgia_rheumatica,carbidopa_28_days).
terapija(polymyalgia_rheumatica,rituximab_21_days).
terapija(polymyalgia_rheumatica,bumetanide_28_days).
terapija(polymyalgia_rheumatica,raloxifene_evista_28_days).
terapija(polymyalgia_rheumatica,latanoprost_28_days).
terapija(polymyalgia_rheumatica,amiodarone_28_days).
terapija(polymyalgia_rheumatica,tolterodine_detrol_28_days).
terapija(polymyalgia_rheumatica,diclofenac_28_days).


sex_factor(myocarditis,male,1.4).
sex_factor(myocarditis,female,0.7).

ages_factor(myocarditis,0,1,0.1).
ages_factor(myocarditis,1,4,0.022).
ages_factor(myocarditis,5,14,0.022).
ages_factor(myocarditis,15,29,1.5).
ages_factor(myocarditis,30,44,1.8).
ages_factor(myocarditis,45,59,0.6).
ages_factor(myocarditis,60,74,0.4).
ages_factor(myocarditis,75,150,2.4).


testovi(myocarditis,radiographic_imaging_procedure).
testovi(myocarditis,hematologic_tests_blood_test).
testovi(myocarditis,complete_blood_count_cbc).
testovi(myocarditis,electrocardiogram).
testovi(myocarditis,plain_x-ray_x_ray).
testovi(myocarditis,echocardiography).
testovi(myocarditis,ultrasonography_ultrasound).
testovi(myocarditis,cardiac_monitoring_cardiac_monitor).


terapija(myocarditis,carvedilol_28_days).
terapija(myocarditis,nitroglycerin_28_days).
terapija(myocarditis,ceftriaxone_7_days).
terapija(myocarditis,magnesium_sulfate_14_days).
terapija(myocarditis,tamoxifen_28_days).
terapija(myocarditis,rosiglitazone_avandia_28_days).
terapija(myocarditis,glimepiride_28_days).
terapija(myocarditis,tiotropium_spiriva_28_days).
terapija(myocarditis,budesonide_28_days).
terapija(myocarditis,olmesartan_benicar_28_days).
terapija(myocarditis,enoxaparin_lovenox_7_days).
terapija(myocarditis,isosorbide_28_days).
terapija(myocarditis,oxygen).


sex_factor(meningitis,male,1.0).
sex_factor(meningitis,female,1.0).

ages_factor(meningitis,0,1,2.9).
ages_factor(meningitis,1,4,1.0).
ages_factor(meningitis,5,14,1.2).
ages_factor(meningitis,15,29,1.1).
ages_factor(meningitis,30,44,1.1).
ages_factor(meningitis,45,59,1.2).
ages_factor(meningitis,60,74,0.5).
ages_factor(meningitis,75,150,0.3).


testovi(meningitis,hematologic_tests_blood_test).
testovi(meningitis,complete_blood_count_cbc).
testovi(meningitis,radiographic_imaging_procedure).
testovi(meningitis,intravenous_fluid_replacement).
testovi(meningitis,glucose_measurement_glucose_level).
testovi(meningitis,urinalysis).
testovi(meningitis,kidney_function_tests_kidney_function_test).
testovi(meningitis,x-ray_computed_tomography_scan_ct).


terapija(meningitis,ceftriaxone_7_days).
terapija(meningitis,vancomycin_7_days).
terapija(meningitis,ampicillin_7_days).
terapija(meningitis,prochlorperazine_compro_14_days).
terapija(meningitis,midazolam_versed).
terapija(meningitis,cefotaxime_7_days).
terapija(meningitis,acyclovir_21_days).
terapija(meningitis,phenobarbital_28_days).
terapija(meningitis,gentamicin_ophthalmic).
terapija(meningitis,cefuroxime_7_days).
terapija(meningitis,micafungin_7_days).
terapija(meningitis,amphotericin_b_14_days).
terapija(meningitis,tapentadol_nucynta_21_days).


sex_factor(multiple_sclerosis,male,0.6).
sex_factor(multiple_sclerosis,female,1.3).

ages_factor(multiple_sclerosis,0,1,0.022).
ages_factor(multiple_sclerosis,1,4,0.022).
ages_factor(multiple_sclerosis,5,14,0.1).
ages_factor(multiple_sclerosis,15,29,0.5).
ages_factor(multiple_sclerosis,30,44,1.7).
ages_factor(multiple_sclerosis,45,59,2.1).
ages_factor(multiple_sclerosis,60,74,0.9).
ages_factor(multiple_sclerosis,75,150,0.2).


testovi(multiple_sclerosis,magnetic_resonance_imaging_mri).
testovi(multiple_sclerosis,physical_therapy_exercises_exercises).
testovi(multiple_sclerosis,other_diagnostic_procedures_interview;_evaluation;_consultation).
testovi(multiple_sclerosis,referral_to_home_health_care_service).
testovi(multiple_sclerosis,other_therapeutic_procedures).
testovi(multiple_sclerosis,occupational_therapy_assessment_speech_therapy).
testovi(multiple_sclerosis,debridement_of_wound;_infection_or_burn).
testovi(multiple_sclerosis,diagnostic_spinal_tap_spinal_tap).


terapija(multiple_sclerosis,interferon_beta_1a_avonex_28_days).
terapija(multiple_sclerosis,glatiramer_copaxone_28_days).
terapija(multiple_sclerosis,baclofen_28_days).
terapija(multiple_sclerosis,modafinil_provigil_28_days).
terapija(multiple_sclerosis,oxybutynin_28_days).
terapija(multiple_sclerosis,tizanidine_28_days).
terapija(multiple_sclerosis,natalizumab_tysabri_28_days).
terapija(multiple_sclerosis,tolterodine_detrol_28_days).
terapija(multiple_sclerosis,amantadine_28_days).
terapija(multiple_sclerosis,solifenacin_vesicare_28_days).
terapija(multiple_sclerosis,azathioprine_28_days).
terapija(multiple_sclerosis,cyclophosphamide_28_days).
terapija(multiple_sclerosis,armodafinil_nuvigil_28_days).


sex_factor(parkinson_disease,male,1.4).
sex_factor(parkinson_disease,female,0.7).

ages_factor(parkinson_disease,0,1,0.022).
ages_factor(parkinson_disease,1,4,0.022).
ages_factor(parkinson_disease,5,14,0.022).
ages_factor(parkinson_disease,15,29,0.022).
ages_factor(parkinson_disease,30,44,0.1).
ages_factor(parkinson_disease,45,59,0.7).
ages_factor(parkinson_disease,60,74,2.8).
ages_factor(parkinson_disease,75,150,4.8).


testovi(parkinson_disease,other_diagnostic_procedures_interview_evaluation_consultation).
testovi(parkinson_disease,physical_therapy_exercises_exercises).
testovi(parkinson_disease,magnetic_resonance_imaging_mri).
testovi(parkinson_disease,depression_screen_depression_screening).
testovi(parkinson_disease,occupational_therapy_assessment_speech_therapy).
testovi(parkinson_disease,prostate_specific_antigen_measurement_prostate_specific_antigen_test).
testovi(parkinson_disease,referral_to_home_health_care_service).
testovi(parkinson_disease,other_or_therapeutic_nervous_system_procedures).


terapija(parkinson_disease,ropinirole_28_days).
terapija(parkinson_disease,pramipexole_mirapex_28_days).
terapija(parkinson_disease,amantadine_28_days).
terapija(parkinson_disease,donepezil_aricept_28_days).
terapija(parkinson_disease,rasagiline_azilect_28_days).
terapija(parkinson_disease,carbidopa_28_days).
terapija(parkinson_disease,entacapone_comtan_28_days).
terapija(parkinson_disease,memantine_namenda_28_days).
terapija(parkinson_disease,selegiline_28_days).
terapija(parkinson_disease,trihexyphenidyl_artane_28_days).
terapija(parkinson_disease,rivastigmine_exelon_28_days).


sex_factor(hypertensive_heart_disease,male,1.0).
sex_factor(hypertensive_heart_disease,female,1.0).

ages_factor(hypertensive_heart_disease,0,1,0.02).
ages_factor(hypertensive_heart_disease,1,4,0.02).
ages_factor(hypertensive_heart_disease,5,14,0.02).
ages_factor(hypertensive_heart_disease,15,29,0.02).
ages_factor(hypertensive_heart_disease,30,44,0.3).
ages_factor(hypertensive_heart_disease,45,59,1.2).
ages_factor(hypertensive_heart_disease,60,74,2.2).
ages_factor(hypertensive_heart_disease,75,150,4.0).


terapija(hypertensive_heart_disease,amlodipine_28_days).
terapija(hypertensive_heart_disease,carvedilol_28_days).
terapija(hypertensive_heart_disease,isosorbide_28_days).
terapija(hypertensive_heart_disease,rosuvastatin_crestor_28_days).
terapija(hypertensive_heart_disease,valsartan_diovan_28_days).
terapija(hypertensive_heart_disease,digoxin_28_days).
terapija(hypertensive_heart_disease,diltiazem_28_days).
terapija(hypertensive_heart_disease,spironolactone_28_days).
terapija(hypertensive_heart_disease,benazepril_28_days).
terapija(hypertensive_heart_disease,hydralazine_28_days).
terapija(hypertensive_heart_disease,torsemide_28_days).
terapija(hypertensive_heart_disease,hyzaar_28_days).


sex_factor(ischemic_heart_disease,male,1.6).
sex_factor(ischemic_heart_disease,female,0.6).

ages_factor(ischemic_heart_disease,0,1,0.02).
ages_factor(ischemic_heart_disease,1,4,0.02).
ages_factor(ischemic_heart_disease,5,14,0.02).
ages_factor(ischemic_heart_disease,15,29,0.02).
ages_factor(ischemic_heart_disease,30,44,0.2).
ages_factor(ischemic_heart_disease,45,59,1.0).
ages_factor(ischemic_heart_disease,60,74,2.9).
ages_factor(ischemic_heart_disease,75,150,3.7).


terapija(ischemic_heart_disease,carvedilol_28_days).
terapija(ischemic_heart_disease,clopidogrel_plavix_28_days).
terapija(ischemic_heart_disease,nitroglycerin_28_days).
terapija(ischemic_heart_disease,digoxin_28_days).
terapija(ischemic_heart_disease,spironolactone_28_days).
terapija(ischemic_heart_disease,isosorbide_28_days).
terapija(ischemic_heart_disease,rosuvastatin_crestor_28_days).
terapija(ischemic_heart_disease,amiodarone_28_days).
terapija(ischemic_heart_disease,niacin_28_days).
terapija(ischemic_heart_disease,fenofibrate_tricor_28_days).
terapija(ischemic_heart_disease,allopurinol_28_days).
terapija(ischemic_heart_disease,torsemide_28_days).
terapija(ischemic_heart_disease,ezetimibe_zetia_28_days).


sex_factor(diabetes,male,1.1).
sex_factor(diabetes,female,1.0).

ages_factor(diabetes,0,1,0.02).
ages_factor(diabetes,1,4,0.02).
ages_factor(diabetes,5,14,0.2).
ages_factor(diabetes,15,29,0.3).
ages_factor(diabetes,30,44,0.7).
ages_factor(diabetes,45,59,1.6).
ages_factor(diabetes,60,74,2.3).
ages_factor(diabetes,75,150,1.5).


terapija(diabetes,metformin_28_days).
terapija(diabetes,insulin).
terapija(diabetes,insulin_glargine_lantus_28_days).
terapija(diabetes,glipizide_28_days).
terapija(diabetes,insulin,_aspart,_human_novolog_28_days).
terapija(diabetes,pioglitazone_actos_28_days).
terapija(diabetes,glyburide_28_days).
terapija(diabetes,glimepiride_28_days).
terapija(diabetes,rosiglitazone_avandia_28_days).
terapija(diabetes,quinapril_28_days).
terapija(diabetes,sitagliptin_januvia_28_days).
terapija(diabetes,exenatide_byetta_28_days).


sex_factor(coagulation_bleeding_disorder,male,0.9).
sex_factor(coagulation_bleeding_disorder,female,1.1).

ages_factor(coagulation_bleeding_disorder,0,1,0.1).
ages_factor(coagulation_bleeding_disorder,1,4,0.3).
ages_factor(coagulation_bleeding_disorder,5,14,0.1).
ages_factor(coagulation_bleeding_disorder,15,29,0.7).
ages_factor(coagulation_bleeding_disorder,30,44,1.0).
ages_factor(coagulation_bleeding_disorder,45,59,1.1).
ages_factor(coagulation_bleeding_disorder,60,74,1.6).
ages_factor(coagulation_bleeding_disorder,75,150,2.1).


terapija(coagulation_bleeding_disorder,warfarin_28_days).
terapija(coagulation_bleeding_disorder,enoxaparin_lovenox_7_days).
terapija(coagulation_bleeding_disorder,heparin_7_days).
terapija(coagulation_bleeding_disorder,pyridoxine).
terapija(coagulation_bleeding_disorder,hydroxychloroquine_plaquenil_28_days).
terapija(coagulation_bleeding_disorder,acarbose_28_days).
terapija(coagulation_bleeding_disorder,vitamin_k_1_mephyton_7_days).
terapija(coagulation_bleeding_disorder,torsemide_28_days).
terapija(coagulation_bleeding_disorder,chlorotrianisene_tace).
terapija(coagulation_bleeding_disorder,protamines_protamine).
terapija(coagulation_bleeding_disorder,factor_viii).
terapija(coagulation_bleeding_disorder,menthol_topical).
terapija(coagulation_bleeding_disorder,levobunolol_ophthalmic).


sex_factor(viral_hepatitis,male,1.4).
sex_factor(viral_hepatitis,female,0.7).

ages_factor(viral_hepatitis,0,1,0.02).
ages_factor(viral_hepatitis,1,4,0.1).
ages_factor(viral_hepatitis,5,14,0.1).
ages_factor(viral_hepatitis,15,29,0.3).
ages_factor(viral_hepatitis,30,44,1.2).
ages_factor(viral_hepatitis,45,59,2.8).
ages_factor(viral_hepatitis,60,74,0.9).
ages_factor(viral_hepatitis,75,150,0.1).


terapija(viral_hepatitis,ribavirin_28_days).
terapija(viral_hepatitis,peginterferon_alfa_2b_sylatron_28_days).
terapija(viral_hepatitis,methadone_28_days).
terapija(viral_hepatitis,spironolactone_28_days).
terapija(viral_hepatitis,emtricitabine-tenofovir).
terapija(viral_hepatitis,lactulose_21_days).
terapija(viral_hepatitis,tacrolimus_prograf_28_days).
terapija(viral_hepatitis,ritonavir_norvir_28_days).
terapija(viral_hepatitis,atazanavir_reyataz_28_days).
terapija(viral_hepatitis,mycophenolate_mofetil_cellcept_28_days).
terapija(viral_hepatitis,epoetin_alfa_procrit_21_days).


sex_factor(gastroesophageal_reflux_disease_gerd,male,1.0).
sex_factor(gastroesophageal_reflux_disease_gerd,female,1.0).

ages_factor(gastroesophageal_reflux_disease_gerd,0,1,2.5).
ages_factor(gastroesophageal_reflux_disease_gerd,1,4,0.5).
ages_factor(gastroesophageal_reflux_disease_gerd,5,14,0.5).
ages_factor(gastroesophageal_reflux_disease_gerd,15,29,0.5).
ages_factor(gastroesophageal_reflux_disease_gerd,30,44,0.9).
ages_factor(gastroesophageal_reflux_disease_gerd,45,59,1.3).
ages_factor(gastroesophageal_reflux_disease_gerd,60,74,1.4).
ages_factor(gastroesophageal_reflux_disease_gerd,75,150,1.1).


terapija(gastroesophageal_reflux_disease_gerd,omeprazole_28_days).
terapija(gastroesophageal_reflux_disease_gerd,esomeprazole_nexium_28_days).
terapija(gastroesophageal_reflux_disease_gerd,ranitidine_28_days).
terapija(gastroesophageal_reflux_disease_gerd,lansoprazole_prevacid_28_days).
terapija(gastroesophageal_reflux_disease_gerd,pantoprazole_28_days).
terapija(gastroesophageal_reflux_disease_gerd,rabeprazole_aciphex_28_days).
terapija(gastroesophageal_reflux_disease_gerd,sucralfate_carafate_28_days).
terapija(gastroesophageal_reflux_disease_gerd,dexlansoprazole_dexilant_28_days).
terapija(gastroesophageal_reflux_disease_gerd,nizatidine_axid_28_days).
terapija(gastroesophageal_reflux_disease_gerd,aluminum_hydroxide_m_a_h_).


sex_factor(chronic_constipation,male,0.9).
sex_factor(chronic_constipation,female,1.1).

ages_factor(chronic_constipation,0,1,2.8).
ages_factor(chronic_constipation,1,4,2.0).
ages_factor(chronic_constipation,5,14,2.1).
ages_factor(chronic_constipation,15,29,0.7).
ages_factor(chronic_constipation,30,44,0.5).
ages_factor(chronic_constipation,45,59,0.6).
ages_factor(chronic_constipation,60,74,0.7).
ages_factor(chronic_constipation,75,150,1.3).


terapija(chronic_constipation,polyethylene_glycol_3350_miralax_28_days).
terapija(chronic_constipation,docusate_colace_21_days).
terapija(chronic_constipation,magnesium_citrate).
terapija(chronic_constipation,bisacodyl_the_magic_bullet_21_days).
terapija(chronic_constipation,lactulose_21_days).
terapija(chronic_constipation,glycerin_fleet_21_days).
terapija(chronic_constipation,psyllium_28_days).
terapija(chronic_constipation,sennosides,_usp_perdiem_28_days).
terapija(chronic_constipation,mineral_oil_stye).
terapija(chronic_constipation,guar_gum).
terapija(chronic_constipation,benzylpenicilloyl_polylysine_pre-pen).
terapija(chronic_constipation,lubiprostone_amitiza_28_days).


sex_factor(emphysema,male,1.9).
sex_factor(emphysema,female,0.3).

ages_factor(emphysema,0,1,2.9).
ages_factor(emphysema,1,4,0.1).
ages_factor(emphysema,5,14,2.1).
ages_factor(emphysema,15,29,2.9).
ages_factor(emphysema,30,44,0.5).
ages_factor(emphysema,45,59,0.02).
ages_factor(emphysema,60,74,0.02).
ages_factor(emphysema,75,150,1.0).


terapija(emphysema,sodium_chloride_deep_sea_7_days).
terapija(emphysema,diphenhydramine_benadryl_21_days).
terapija(emphysema,hydromorphone_dilaudid_21_days).
terapija(emphysema,sucralfate_carafate_28_days).
terapija(emphysema,nicotine_21_days).
terapija(emphysema,zosyn_7_days).
terapija(emphysema,epinephrine_7_days).
terapija(emphysema,budesonide_28_days).
terapija(emphysema,adderall).
terapija(emphysema,losartan_28_days).
terapija(emphysema,combivent_28_days).
terapija(emphysema,penicillin).
terapija(emphysema,paroxetine_paxil_28_days).


sex_factor(urinary_tract_infection,male,0.4).
sex_factor(urinary_tract_infection,female,1.5).

ages_factor(urinary_tract_infection,0,1,0.4).
ages_factor(urinary_tract_infection,1,4,0.6).
ages_factor(urinary_tract_infection,5,14,0.6).
ages_factor(urinary_tract_infection,15,29,1.5).
ages_factor(urinary_tract_infection,30,44,1.0).
ages_factor(urinary_tract_infection,45,59,0.7).
ages_factor(urinary_tract_infection,60,74,0.9).
ages_factor(urinary_tract_infection,75,150,1.7).


terapija(urinary_tract_infection,ciprofloxacin_7_days).
terapija(urinary_tract_infection,bactrim_14_days).
terapija(urinary_tract_infection,nitrofurantoin_21_days).
terapija(urinary_tract_infection,levofloxacin_levaquin_7_days).
terapija(urinary_tract_infection,phenazopyridine_azo_7_days).
terapija(urinary_tract_infection,trimethoprim_28_days).
terapija(urinary_tract_infection,cefixime_suprax_7_days).
terapija(urinary_tract_infection,oxacillin_7_days).
terapija(urinary_tract_infection,cefpodoxime_7_days).
terapija(urinary_tract_infection,clofazimine).
terapija(urinary_tract_infection,trospium_sanctura_28_days).


sex_factor(dementia,male,0.9).
sex_factor(dementia,female,1.1).

ages_factor(dementia,0,1,0.02).
ages_factor(dementia,1,4,0.02).
ages_factor(dementia,5,14,0.2).
ages_factor(dementia,15,29,0.1).
ages_factor(dementia,30,44,0.1).
ages_factor(dementia,45,59,0.6).
ages_factor(dementia,60,74,2.0).
ages_factor(dementia,75,150,5.8).


terapija(dementia,donepezil_aricept_28_days).
terapija(dementia,memantine_namenda_28_days).
terapija(dementia,rivastigmine_exelon_28_days).
terapija(dementia,galantamine_28_days).
terapija(dementia,mirtazapine_28_days).
terapija(dementia,thiamine_28_days).
terapija(dementia,pramipexole_mirapex_28_days).
terapija(dementia,felodipine_28_days).
terapija(dementia,bisacodyl_the_magic_bullet_21_days).
terapija(dementia,modafinil_provigil_28_days).
terapija(dementia,raloxifene_evista_28_days).
terapija(dementia,deferasirox_exjade_28_days).


sex_factor(hyperlipidemia,male,1.1).
sex_factor(hyperlipidemia,female,0.9).

ages_factor(hyperlipidemia,0,1,0.02).
ages_factor(hyperlipidemia,1,4,0.02).
ages_factor(hyperlipidemia,5,14,0.1).
ages_factor(hyperlipidemia,15,29,0.1).
ages_factor(hyperlipidemia,30,44,0.6).
ages_factor(hyperlipidemia,45,59,1.7).
ages_factor(hyperlipidemia,60,74,2.5).
ages_factor(hyperlipidemia,75,150,1.7).


terapija(hyperlipidemia,simvastatin_28_days).
terapija(hyperlipidemia,omega_3_fatty_acids).
terapija(hyperlipidemia,rosuvastatin_crestor_28_days).
terapija(hyperlipidemia,pravastatin_28_days).
terapija(hyperlipidemia,fenofibrate_tricor_28_days).
terapija(hyperlipidemia,lovastatin_28_days).
terapija(hyperlipidemia,ezetimibe_zetia_28_days).
terapija(hyperlipidemia,niacin_28_days).
terapija(hyperlipidemia,gemfibrozil_28_days).


sex_factor(cardiomyopathy,male,1.4).
sex_factor(cardiomyopathy,female,0.7).

ages_factor(cardiomyopathy,0,1,0.02).
ages_factor(cardiomyopathy,1,4,0.1).
ages_factor(cardiomyopathy,5,14,0.1).
ages_factor(cardiomyopathy,15,29,0.2).
ages_factor(cardiomyopathy,30,44,0.8).
ages_factor(cardiomyopathy,45,59,1.4).
ages_factor(cardiomyopathy,60,74,2.1).
ages_factor(cardiomyopathy,75,150,2.3).


terapija(cardiomyopathy,carvedilol_28_days).
terapija(cardiomyopathy,furosemide_28_days).
terapija(cardiomyopathy,lisinopril_28_days).
terapija(cardiomyopathy,warfarin_28_days).
terapija(cardiomyopathy,spironolactone_28_days).
terapija(cardiomyopathy,digoxin_28_days).
terapija(cardiomyopathy,amiodarone_28_days).
terapija(cardiomyopathy,enalapril_28_days).
terapija(cardiomyopathy,rosuvastatin_crestor_28_days).
terapija(cardiomyopathy,ramipril_28_days).
terapija(cardiomyopathy,losartan_28_days).
terapija(cardiomyopathy,isosorbide_28_days).
terapija(cardiomyopathy,torsemide_28_days).


sex_factor(bronchiectasis,male,0.5).
sex_factor(bronchiectasis,female,1.4).

ages_factor(bronchiectasis,0,1,0.02).
ages_factor(bronchiectasis,1,4,0.5).
ages_factor(bronchiectasis,5,14,0.7).
ages_factor(bronchiectasis,15,29,0.7).
ages_factor(bronchiectasis,30,44,0.4).
ages_factor(bronchiectasis,45,59,0.8).
ages_factor(bronchiectasis,60,74,2.1).
ages_factor(bronchiectasis,75,150,2.5).


terapija(bronchiectasis,tiotropium_spiriva_28_days).
terapija(bronchiectasis,combivent_28_days).
terapija(bronchiectasis,tobramycin_tobi_14_days).
terapija(bronchiectasis,moxifloxacin_avelox_14_days).
terapija(bronchiectasis,aztreonam_7_days).
terapija(bronchiectasis,robitussin_dm_7_days).
terapija(bronchiectasis,oxybutynin_28_days).
terapija(bronchiectasis,alprostadil_muse_21_days).
terapija(bronchiectasis,ethambutol_28_days).
terapija(bronchiectasis,cefotetan_7_days).


sex_factor(celiac_disease,male,0.6).
sex_factor(celiac_disease,female,1.3).

ages_factor(celiac_disease,0,1,0.02).
ages_factor(celiac_disease,1,4,0.8).
ages_factor(celiac_disease,5,14,2.8).
ages_factor(celiac_disease,15,29,0.7).
ages_factor(celiac_disease,30,44,1.2).
ages_factor(celiac_disease,45,59,0.6).
ages_factor(celiac_disease,60,74,1.2).
ages_factor(celiac_disease,75,150,0.5).


terapija(celiac_disease,dicyclomine_28_days).
terapija(celiac_disease,insulin,_aspart,_human_novolog_28_days).
terapija(celiac_disease,glucagon_7_days).
terapija(celiac_disease,estradiol_28_days).
terapija(celiac_disease,carbenicillin).
terapija(celiac_disease,disopyramide_28_days).
terapija(celiac_disease,nitroprusside).
terapija(celiac_disease,aloe_vera_topical).
terapija(celiac_disease,ketotifen_ophthalmic).
terapija(celiac_disease,nizatidine_axid_28_days).


sex_factor(gastritis,male,0.9).
sex_factor(gastritis,female,1.0).

ages_factor(gastritis,0,1,0.3).
ages_factor(gastritis,1,4,0.7).
ages_factor(gastritis,5,14,0.8).
ages_factor(gastritis,15,29,1.3).
ages_factor(gastritis,30,44,1.3).
ages_factor(gastritis,45,59,1.0).
ages_factor(gastritis,60,74,0.8).
ages_factor(gastritis,75,150,0.6).


terapija(gastritis,famotidine_28_days).
terapija(gastritis,pantoprazole_28_days).
terapija(gastritis,ranitidine_28_days).
terapija(gastritis,sucralfate_carafate_28_days).
terapija(gastritis,cimetidine_28_days).
terapija(gastritis,bismuth_subsalicylate_pepto-bismol_14_days).
terapija(gastritis,amylases).
terapija(gastritis,benzocaine_topical).
terapija(gastritis,aluminum_hydroxide_m_a_h_).
terapija(gastritis,dexlansoprazole_dexilant_28_days).


sex_factor(cirrhosis,male,1.4).
sex_factor(cirrhosis,female,0.7).

ages_factor(cirrhosis,0,1,0.2).
ages_factor(cirrhosis,1,4,0.1).
ages_factor(cirrhosis,5,14,0.1).
ages_factor(cirrhosis,15,29,0.1).
ages_factor(cirrhosis,30,44,0.7).
ages_factor(cirrhosis,45,59,2.6).
ages_factor(cirrhosis,60,74,1.7).
ages_factor(cirrhosis,75,150,0.5).


terapija(cirrhosis,furosemide_28_days).
terapija(cirrhosis,spironolactone_28_days).
terapija(cirrhosis,lactulose_21_days).
terapija(cirrhosis,tacrolimus_prograf_28_days).
terapija(cirrhosis,nadolol_28_days).
terapija(cirrhosis,mycophenolate_mofetil_cellcept_28_days).
terapija(cirrhosis,propranolol_28_days).
terapija(cirrhosis,thiamine_28_days).
terapija(cirrhosis,methadone_28_days).
terapija(cirrhosis,ursodiol_urso).
terapija(cirrhosis,epoetin_alfa_procrit_21_days).
terapija(cirrhosis,peginterferon_alfa_2b_sylatron_28_days).
terapija(cirrhosis,zinc_sulfate_28_days).


sex_factor(hyponatremia,male,0.8).
sex_factor(hyponatremia,female,1.1).

ages_factor(hyponatremia,0,1,0.3).
ages_factor(hyponatremia,1,4,0.1).
ages_factor(hyponatremia,5,14,0.02).
ages_factor(hyponatremia,15,29,0.2).
ages_factor(hyponatremia,30,44,0.4).
ages_factor(hyponatremia,45,59,1.2).
ages_factor(hyponatremia,60,74,1.7).
ages_factor(hyponatremia,75,150,4.1).


terapija(hyponatremia,sodium_bicarbonate_21_days).
terapija(hyponatremia,econazole_topical).
terapija(hyponatremia,desmopressin_28_days).
terapija(hyponatremia,sodium_polystyrene_sulfonate_kayexalate_14_days).
terapija(hyponatremia,metipranolol_ophthalmic).
terapija(hyponatremia,diphenoxylate_lomotil).
terapija(hyponatremia,dofetilide_tikosyn_28_days).
terapija(hyponatremia,tiagabine_gabitril_28_days).
terapija(hyponatremia,lipase).


sex_factor(cerebral_palsy,male,1.4).
sex_factor(cerebral_palsy,female,0.7).

ages_factor(cerebral_palsy,0,1,0.8).
ages_factor(cerebral_palsy,1,4,2.7).
ages_factor(cerebral_palsy,5,14,4.4).
ages_factor(cerebral_palsy,15,29,1.3).
ages_factor(cerebral_palsy,30,44,0.5).
ages_factor(cerebral_palsy,45,59,0.2).
ages_factor(cerebral_palsy,60,74,0.2).
ages_factor(cerebral_palsy,75,150,0.02).


terapija(cerebral_palsy,baclofen_28_days).
terapija(cerebral_palsy,levetiracetam_keppra_28_days).
terapija(cerebral_palsy,botulinum_toxin_type_a_botox).
terapija(cerebral_palsy,topiramate_topamax_28_days).
terapija(cerebral_palsy,carbamazepine_28_days).
terapija(cerebral_palsy,phenobarbital_28_days).
terapija(cerebral_palsy,polyethylene_glycol_3350_miralax_28_days).
terapija(cerebral_palsy,glycopyrrolate_28_days).
terapija(cerebral_palsy,oxcarbazepine_trileptal_28_days).
terapija(cerebral_palsy,budesonide_28_days).
terapija(cerebral_palsy,zonisamide_28_days).
terapija(cerebral_palsy,tizanidine_28_days).
terapija(cerebral_palsy,clorazepate_28_days).


sex_factor(encephalitis,male,1.2).
sex_factor(encephalitis,female,0.8).

ages_factor(encephalitis,0,1,0.6).
ages_factor(encephalitis,1,4,0.3).
ages_factor(encephalitis,5,14,1.8).
ages_factor(encephalitis,15,29,0.6).
ages_factor(encephalitis,30,44,1.1).
ages_factor(encephalitis,45,59,1.6).
ages_factor(encephalitis,60,74,1.0).
ages_factor(encephalitis,75,150,0.2).


terapija(encephalitis,baclofen_28_days).
terapija(encephalitis,gabapentin_28_days).
terapija(encephalitis,tizanidine_28_days).
terapija(encephalitis,diazepam_valium_28_days).
terapija(encephalitis,pregabalin_lyrica_28_days).
terapija(encephalitis,lamotrigine_lamictal_28_days).
terapija(encephalitis,interferon_beta_1a_avonex_28_days).
terapija(encephalitis,valproic_acid).
terapija(encephalitis,vancomycin_7_days).
terapija(encephalitis,diclofenac_28_days).
terapija(encephalitis,topiramate_topamax_28_days).
terapija(encephalitis,albumin_human,_usp_albutein).
terapija(encephalitis,oxaprozin_28_days).


sex_factor(bell_palsy,male,0.9).
sex_factor(bell_palsy,female,1.1).

ages_factor(bell_palsy,0,1,0.2).
ages_factor(bell_palsy,1,4,0.2).
ages_factor(bell_palsy,5,14,0.4).
ages_factor(bell_palsy,15,29,0.9).
ages_factor(bell_palsy,30,44,1.3).
ages_factor(bell_palsy,45,59,1.4).
ages_factor(bell_palsy,60,74,1.0).
ages_factor(bell_palsy,75,150,1.1).


terapija(bell_palsy,prednisone_28_days).
terapija(bell_palsy,acyclovir_21_days).
terapija(bell_palsy,valacyclovir_valtrex_21_days).
terapija(bell_palsy,famciclovir_14_days).
terapija(bell_palsy,olopatadine_ophthalmic).
terapija(bell_palsy,lyme_disease_vaccine).
terapija(bell_palsy,dextran_1).
terapija(bell_palsy,rimabotulinumtoxinb_myobloc_28_days).
terapija(bell_palsy,diclofenac_topical_product).
terapija(bell_palsy,tetrahydrozoline_ophthalmic).
terapija(bell_palsy,biotin_28_days).
terapija(bell_palsy,mineral_oil_stye).




